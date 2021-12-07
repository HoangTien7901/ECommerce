package com.demo.controllers.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.helpers.MailHelper;
import com.demo.helpers.PasswordGenerator;
import com.demo.models.StoreInfo;
import com.demo.models.UserInfo;
import com.demo.services.manager.IStoreService;
import com.demo.services.manager.ISystemService;
import com.demo.services.user.ICartService;
import com.demo.services.user.IUserService;
import com.demo.validators.UserValidator;

@Controller
@RequestMapping(value = { "user/account" })
public class AccountController {

	@Autowired
	private IUserService service;

	@Autowired
	private IUserService userService;

	@Autowired
	private ISystemService systemService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = { "login" }, method = RequestMethod.GET)
	public String login(@RequestParam(value = "error", required = false) String error, ModelMap modelMap,
			HttpServletRequest request) {
		if (error != null) {
			modelMap.put("msg", "Invalid username or password.");
			modelMap.put("msgType", "danger");
		}

		HttpSession session = request.getSession();

		// ============= getting store and contact info
		modelMap.put("store", session.getAttribute("store"));
		modelMap.put("contact", session.getAttribute("contact"));

		return "user/account/login";
	}

	@RequestMapping(value = { "login" }, method = RequestMethod.POST)
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			RedirectAttributes redirectAttr, ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();

		ResponseEntity<UserInfo> responseEntity = service.findInfoByUsername(username);
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {

			UserInfo user = responseEntity.getBody();

			if (BCrypt.checkpw(password, user.getPassword())) {
				session.setAttribute("id", user.getId());
				session.setAttribute("userId", user.getId());
				session.setAttribute("username", user.getUsername());
				session.setAttribute("roleId", user.getRoleId());

				redirectAttr.addFlashAttribute("msg", "Login success!");
				redirectAttr.addFlashAttribute("msgType", "success");

				return "redirect:/user/home/index";
			} else {
				modelMap.put("msg", "Invalid username or password.");
				modelMap.put("msgType", "danger");

				return "user/account/login";
			}
		} else {
			if (responseEntity == null) {
				modelMap.put("msg", "Can't find any user with username " + username);
			} else {
				modelMap.put("msg", "Find user by username result " + responseEntity.getStatusCode());
			}

			modelMap.put("msgType", "danger");

			return "redirect:/user/home/index";
		}
	}

	@RequestMapping(value = { "logoutOld" }, method = RequestMethod.GET)
	public String logout(ModelMap modelMap, HttpServletRequest request, RedirectAttributes redirectAttr) {
		HttpSession session = request.getSession();

		// delete cart on logout here
		if (session.getAttribute("cartId") != null) {
			int cartId = (int) session.getAttribute("cartId");
			ResponseEntity<Void> response = cartService.deleteIfUnfinished(cartId);
			if (!(response == null || response.getStatusCode() != HttpStatus.OK)) {
				redirectAttr.addFlashAttribute("msg", "Logout success!");
				redirectAttr.addFlashAttribute("msgType", "success");
			} else {
				redirectAttr.addFlashAttribute("msg",
						"Delete cart result " + (response == null ? "null" : response.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}
		}

		session.invalidate();

		return "redirect:/user/home/index";
	}

	@RequestMapping(value = { "register" }, method = RequestMethod.GET)
	public String register(ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();

		UserInfo user = new UserInfo();
		user.setPassword(new BCryptPasswordEncoder().encode("123"));
		modelMap.put("item", user);

		// ============= getting store and contact info
		modelMap.put("store", session.getAttribute("store"));
		modelMap.put("contact", session.getAttribute("contact"));

		return "user/account/register";
	}

	@RequestMapping(value = { "register" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("item") @Valid UserInfo _object, BindingResult errors,
			@RequestParam("birthday") String _birthday, RedirectAttributes redirectAttr, ModelMap modelMap) {
		userValidator.validate(_object, errors);
		if (errors.hasErrors()) {
			return "user/account/register";
		} else {
			ResponseEntity<com.demo.models.System> systemResponse = systemService.getSystem();
			if (!(systemResponse == null || systemResponse.getStatusCode() != HttpStatus.OK)) {

				// set birthday
				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
				formater.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
				Date birthday = new Date();
				try {
					birthday = formater.parse(_birthday);
				} catch (ParseException e) {
					redirectAttr.addFlashAttribute("msg", "Client parse birthday error: " + e.getMessage());
					redirectAttr.addFlashAttribute("msgType", "danger");
				}
				_object.setBirthday(birthday);

				// generate a random password
				PasswordGenerator passGenerator = new PasswordGenerator();
				String password = passGenerator.generateRndPassword();
				System.out.print("password : " + password);
				_object.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));

				// send password to user email
				com.demo.models.System system = systemResponse.getBody();
				MailHelper mailHelper = new MailHelper();
				try {
					mailHelper.sendmail(system.getEmail(), system.getEmailPassword(),
							system.getDefaultPasswordEmailSubject(), system.getDefaultPasswordEmailContent() + password,
							_object.getEmail(), false);

					// create user
					ResponseEntity<UserInfo> responseEntity = service.create(_object);
					if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
						UserInfo user = responseEntity.getBody();
						// set session here

						redirectAttr.addFlashAttribute("msg", "Sign up success!");
						redirectAttr.addFlashAttribute("msgType", "success");

						return "redirect:/user/home/index";
					} else {
						modelMap.put("msg", "Server - Create user result "
								+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
						modelMap.put("msgType", "danger");

						return "user/account/register";
					}
				} catch (Exception e) {
					modelMap.put("msg", "Error sending mail to email " + _object.getEmail() + ": " + e.getMessage());
					modelMap.put("msgType", "danger");

					return "user/account/register";
				}
			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Get system info result "
						+ (systemResponse == null ? "null" : systemResponse.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");

				return "redirect:/user/home/index";
			}
		}
	}

	@RequestMapping(value = { "profile" }, method = RequestMethod.GET)
	public String profile(ModelMap modelMap, HttpServletRequest request, RedirectAttributes redirectAttr) {
		HttpSession session = request.getSession();

		// ============= getting store and contact info
		modelMap.put("store", session.getAttribute("store"));
		modelMap.put("contact", session.getAttribute("contact"));

		if (session.getAttribute("username") != null) {
			String username = (String) session.getAttribute("username");
			ResponseEntity<UserInfo> userResponse = userService.findInfoByUsername(username);
			if (!(userResponse == null || userResponse.getStatusCode() != HttpStatus.OK)) {
				UserInfo user = userResponse.getBody();
				modelMap.put("item", user);
			} else {
				redirectAttr.addFlashAttribute("msg", "Server : find account by username " + username + " result "
						+ (userResponse == null ? "null" : userResponse.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");

				return "redirect:/user/account/index";
			}
		} else {
			redirectAttr.addFlashAttribute("msg", "Session error : can't find username");
			redirectAttr.addFlashAttribute("msgType", "danger");
			return "redirect:/user/account/index";
		}

		return "user/account/profile";
	}

	@RequestMapping(value = { "changePassword" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("oldPassword") String oldPassword,
			@ModelAttribute("newPassword") String password, ModelMap modelMap, RedirectAttributes redirectAttr,
			HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("username") != null) {
			String username = (String) session.getAttribute("username");

			ResponseEntity<UserInfo> responseEntity = userService.findInfoByUsername(username);
			UserInfo result = responseEntity.getBody();
			if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {

				if (BCrypt.checkpw(oldPassword, result.getPassword())) {

					String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt());
					result.setPassword(pw_hash);

					ResponseEntity<Void> responseEntity2 = userService.update(result);
					if (responseEntity2 != null && responseEntity2.getStatusCode() == HttpStatus.OK) {
						redirectAttr.addFlashAttribute("msg", "Change password success! Please login again");
						redirectAttr.addFlashAttribute("msgType", "success");

						// delete cart on logout here
						if (session.getAttribute("cartId") != null) {
							int cartId = (int) session.getAttribute("cartId");
							ResponseEntity<Void> response = cartService.deleteIfUnfinished(cartId);
							if (!(response == null || response.getStatusCode() != HttpStatus.OK)) {
							} else {
								redirectAttr.addFlashAttribute("msg",
										"Delete cart result " + (response == null ? "null" : response.getStatusCode()));
								redirectAttr.addFlashAttribute("msgType", "danger");
							}
						}

						session.invalidate();
					} else {
						redirectAttr.addFlashAttribute("msg", "Server - Change password result "
								+ (responseEntity2 == null ? "null" : responseEntity2.getStatusCode()));
						redirectAttr.addFlashAttribute("msgType", "danger");
					}
				} else {
					redirectAttr.addFlashAttribute("msg", "Invalid old password.");
					redirectAttr.addFlashAttribute("msgType", "danger");
				}
			} else {
				modelMap.put("msg", "Server - Get profile by id result "
						+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				modelMap.put("msgType", "danger");

				modelMap.put("title", (String) session.getAttribute("title"));

				return "user/account/profile";
			}
		} else {
			modelMap.put("msg", "Session error - Can't get username");
			modelMap.put("msgType", "danger");

			modelMap.put("title", (String) session.getAttribute("title"));

			return "user/account/index";
		}

		return "redirect:/user/home/index";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") @Valid UserInfo item, BindingResult errors, ModelMap modelMap,
			@RequestParam("birthday") String _birthday, RedirectAttributes redirectAttr, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		// if username does not change, don't check
		if (!username.equals(item.getUsername())) {
			userValidator.validate(item, errors);
		}
		if (errors.hasErrors()) {
			modelMap.put("title", (String) session.getAttribute("title"));
			return "user/account/profile";
		} else {
			SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
			formater.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
			Date birthday = new Date();

			try {
				birthday = formater.parse(_birthday);
			} catch (ParseException e) {
				redirectAttr.addFlashAttribute("msg", "Client user parse date error: " + e.getMessage());
				redirectAttr.addFlashAttribute("msgType", "danger");
			}

			item.setBirthday(birthday);

			session.setAttribute("username", item.getUsername());

			ResponseEntity<Void> responseEntity = userService.update(item);
			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
				redirectAttr.addFlashAttribute("msg", "Update success!");
				redirectAttr.addFlashAttribute("msgType", "success");
			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Update user result "
						+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}

			return "redirect:/user/home/index";
		}
	}

	@RequestMapping(value = { "accessDenied" }, method = RequestMethod.GET)
	public String accessDenied(ModelMap modelMap, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		// ============= getting store and contact info
		modelMap.put("store", session.getAttribute("store"));
		modelMap.put("contact", session.getAttribute("contact"));

		return "user/account/accessDenied";
	}
}
