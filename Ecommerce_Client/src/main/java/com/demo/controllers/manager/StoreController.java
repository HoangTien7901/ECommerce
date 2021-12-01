package com.demo.controllers.manager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.helpers.FileUploadHelper;
import com.demo.helpers.MailHelper;
import com.demo.models.CategoryInfo;
import com.demo.models.StoreInfo;
import com.demo.models.UserInfo;
import com.demo.services.manager.IStoreService;
import com.demo.services.manager.ISystemService;
import com.demo.services.manager.IUserService;

@Controller
@RequestMapping("manager/store")
public class StoreController implements ServletContextAware {

	private ServletContext servletContext;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private ISystemService systemService;
	
	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String edit(ModelMap modelMap) {
		ResponseEntity<StoreInfo> responseEntity = storeService.findInfoById(1);

		modelMap.put("title", "Edit store");
		modelMap.put("storeActive", "active");

		modelMap.put("parentPageTitle", "Store");

		StoreInfo result = responseEntity.getBody();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("img", result.getLogo());
			modelMap.put("item", result);
		} else {
			modelMap.put("msg", "Server - Get store info result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}

		return "manager/store/index";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(ModelMap modelMap, @ModelAttribute("item") @Valid StoreInfo item, BindingResult errors,
			@RequestParam(name = "newLogo", required = false) MultipartFile newLogo
			, RedirectAttributes redirectAttr) {
		ResponseEntity<com.demo.models.System> systemResponse = systemService.getSystem();
		com.demo.models.System system = systemResponse.getBody();
		
		if (errors.hasErrors()) {
			modelMap.put("title", "Edit store");
			modelMap.put("storeActive", "active");

			modelMap.put("img", item.getLogo());
			modelMap.put("pageTitle", "Edit");
			modelMap.put("parentPageTitle", "Store");

			return "manager/store/index";
		} else {
			// upload new avatar
			if (!newLogo.isEmpty()) {
				if (newLogo.getSize() / 1024 / 1024 > system.getMaxBannerPhotoSize()) {
					redirectAttr.addFlashAttribute("msg", "File is too large: " + (newLogo.getSize() / 1024 / 1024)
							+ ". Maximum file size is: " + system.getMaxBannerPhotoSize());
					redirectAttr.addFlashAttribute("msgType", "danger");
				} else {
					try {
						// delete old image
						Path fileToDeletePath = Paths.get("src/main/webapp/uploads/images/" + item.getLogo());
						Files.delete(fileToDeletePath);

						String fileName = FileUploadHelper.upload(newLogo, servletContext);
						item.setLogo(fileName);
					} catch (Exception e) {
						redirectAttr.addFlashAttribute("msg", "Delete old product's avatar error: " + e.getMessage());
						redirectAttr.addFlashAttribute("msgType", "danger");
					}
				}
			}

			ResponseEntity<Void> responseEntity = storeService.update(item);
			if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
				redirectAttr.addFlashAttribute("msg", "Update success!");
				redirectAttr.addFlashAttribute("msgType", "success");
			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Find update store result " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}

			return "redirect:/manager/store/index";
		}

	}

//	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
//	public String delete(@PathVariable("id") int id) {
//		ResponseEntity<Void> responseEntity = storeService.delete(id);
//		if (responseEntity != null) {
//			if (responseEntity.getStatusCode() == HttpStatus.OK) {
//
//			} else {
//
//			}
//		}
//		return "redirect:/manager/store/index";
//	}
//
//	@RequestMapping(value = { "toggleStatus/{id}" }, method = RequestMethod.GET)
//	public String toggleStatus(@PathVariable("id") int id) {
//		ResponseEntity<Void> responseEntity = storeService.toggleStatus(id);
//		if (responseEntity != null) {
//			if (responseEntity.getStatusCode() == HttpStatus.OK) {
//				// just send some temporary text to make it not null
//				responseEntity = storeService.updateBanTerm(id, "tmp");
//			} else {
//
//			}
//		}
//		return "redirect:/manager/store/index";
//	}
//
//	@RequestMapping(value = { "ban/{id}" }, method = RequestMethod.GET)
//	public String ban(@PathVariable("id") int id, ModelMap modelMap) {
//		ResponseEntity<StoreInfo> responseEntity = storeService.findInfoById(id);
//		StoreInfo result = responseEntity.getBody();
//
//		if (responseEntity != null) {
//			if (responseEntity.getStatusCode() == HttpStatus.OK) {
//				modelMap.put("id", result.getId());
//				modelMap.put("storeName", result.getName());
//
//				modelMap.put("title", "Ban store");
//				modelMap.put("storeActive", "active");
//
//				modelMap.put("pageTitle", "Ban");
//				modelMap.put("parentPageTitle", "Store");
//			}
//		}
//		return "manager/store/ban";
//	}
//
//	@RequestMapping(value = { "ban" }, method = RequestMethod.POST)
//	public String ban(@RequestParam("id") int id, @RequestParam("subject") String subject,
//			@RequestParam("banDuration") int banDuration, @RequestParam("content") String content,
//			@RequestParam(value = "isHTMLText", required = false) boolean isHTMLText) {
//		ResponseEntity<StoreInfo> storeResponseEntity = storeService.findInfoById(id);
//		String recipient = "";
//		if (storeResponseEntity != null && storeResponseEntity.getStatusCode() == HttpStatus.OK) {
//			recipient = storeResponseEntity.getBody().getEmail();
//
//			Date today = new Date();
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(today);
//			calendar.add(Calendar.MONTH, banDuration);
//			SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
//
//			ResponseEntity<Void> responseEntity = storeService.updateBanTerm(id, formater.format(calendar.getTime()));
//			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
//
//				// send mail
//				MailHelper mailHelper = new MailHelper();
//				try {
////					mailHelper.sendmail("<email here>", "<password here>", subject, content, recipient, isHTMLText);
//				} catch (Exception e) {
//					System.out.println("Client store send mail failed: " + e.getMessage());
//				}
//			} else {
//				System.out.println("Client store update ban term failed: " + responseEntity == null ? "null"
//						: responseEntity.getStatusCode());
//			}
//
//			responseEntity = storeService.toggleStatus(id);
//			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
//
//			} else {
//				System.out.println("Client change store status failed : " + responseEntity == null ? "null"
//						: responseEntity.getStatusCode());
//			}
//		} else {
//			System.out.println("Client user get store by id failed: " + storeResponseEntity == null ? "null"
//					: storeResponseEntity.getStatusCode());
//		}
//
//		return "redirect:/manager/store/index";
//	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}