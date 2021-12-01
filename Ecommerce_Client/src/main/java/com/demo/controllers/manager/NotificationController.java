package com.demo.controllers.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.models.NotificationInfo;
import com.demo.models.StoreInfo;
import com.demo.models.UserInfo;
import com.demo.services.manager.INotificationService;
import com.demo.services.manager.IStoreService;
import com.demo.services.manager.IUserService;

@Controller
@RequestMapping("manager/notification")
public class NotificationController {

	@Autowired
	private INotificationService notificationService;

	@Autowired
	private IStoreService storeService;

	@Autowired
	private IUserService userService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("title", "Manage notification");
		modelMap.put("notificationActive", "active");

		modelMap.put("pageTitle1", "User notification list");
		modelMap.put("pageTitle2", "Store notification list");
		modelMap.put("pageTitle3", "All user/store notification list");

		modelMap.put("parentPageTitle", "Notification");

		ResponseEntity<Iterable<NotificationInfo>> responseEntity = notificationService.findAllInfo();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			Iterable<NotificationInfo> result = responseEntity.getBody();

			List<NotificationInfo> users = new ArrayList<NotificationInfo>();
			List<NotificationInfo> stores = new ArrayList<NotificationInfo>();
			List<NotificationInfo> all = new ArrayList<NotificationInfo>();

			for (NotificationInfo item : result) {
				if (item.getUserId() != null) {
					users.add(item);
				} else if (item.getStoreId() != null) {
					stores.add(item);
				} else if (item.isAllUser() || item.isAllStore()) {
					all.add(item);
				}
			}

			modelMap.put("users", users);
			modelMap.put("stores", stores);
			modelMap.put("all", all);
		} else {
			modelMap.put("msg", "Server - Get all notification result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		return "manager/notification/index";
	}

	@RequestMapping(value = { "editAll/{id}" }, method = RequestMethod.GET)
	public String editAll(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.put("title", "Edit notification");
		modelMap.put("notificationActive", "active");

		modelMap.put("editType", "All");

		modelMap.put("pageTitle", "Edit notification for all user/store");
		modelMap.put("parentPageTitle", "Notification");
		
		ResponseEntity<NotificationInfo> responseEntity = notificationService.findInfoById(id);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("item", responseEntity.getBody());
		} else {
			modelMap.put("msg", "Server - Get notification by id result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		return "manager/notification/editAll";
	}

	@RequestMapping(value = { "editUser/{id}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable("id") int id, ModelMap modelMap
			, RedirectAttributes redirectAttr) {
		modelMap.put("title", "Edit notification");
		modelMap.put("notificationActive", "active");

		modelMap.put("editType", "User");

		modelMap.put("pageTitle", "Edit notification for store");
		modelMap.put("parentPageTitle", "Notification");
		
		ResponseEntity<NotificationInfo> responseEntity = notificationService.findInfoById(id);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			ResponseEntity<Iterable<UserInfo>> responseEntity2 = userService.findAllInfo();
			if (!(responseEntity2 == null || responseEntity2.getStatusCode() != HttpStatus.OK)) {
				modelMap.put("items", responseEntity2.getBody());
				modelMap.put("item", responseEntity.getBody());
			} else {
				modelMap.put("msg", "Server - Get all user for selection result "
						+ (responseEntity2 == null ? "null" : responseEntity2.getStatusCode()));
				modelMap.put("msgType", "danger");
			}
		} else {
			modelMap.put("msg", "Server - Get user notification by id result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		
		return "manager/notification/editUser";
	}

	@RequestMapping(value = { "editStore/{id}" }, method = RequestMethod.GET)
	public String editStore(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.put("title", "Edit notification");
		modelMap.put("notificationActive", "active");

		modelMap.put("editType", "Store");

		modelMap.put("pageTitle", "Edit notification for store");
		modelMap.put("parentPageTitle", "Notification");
		
		ResponseEntity<NotificationInfo> responseEntity = notificationService.findInfoById(id);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			ResponseEntity<Iterable<StoreInfo>> responseEntity2 = storeService.findAllInfo();
			if (!(responseEntity2 == null || responseEntity2.getStatusCode() != HttpStatus.OK)) {
				modelMap.put("items", responseEntity2.getBody());

				modelMap.put("item", responseEntity.getBody());
			} else {
				modelMap.put("msg", "Server - Get all store for selection result "
						+ (responseEntity2 == null ? "null" : responseEntity2.getStatusCode()));
				modelMap.put("msgType", "danger");
			}
		} else {
			modelMap.put("msg", "Server - Get store notification by id result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}
		
		return "manager/notification/editStore";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") @Valid NotificationInfo item, BindingResult errors,
			@RequestParam("editType") String editType, ModelMap modelMap
			, RedirectAttributes redirectAttr) {

		if (editType.equals("User")) {
			ResponseEntity<Iterable<UserInfo>> responseEntity = userService.findAllInfo();
			if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
				modelMap.put("items", responseEntity.getBody());
				modelMap.put("pageTitle", "Add notification for user");
			} else {
				modelMap.put("msg", "Server - Get all user for selection result "
						+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				modelMap.put("msgType", "danger");
			}
		} else if (editType.equals("Store")) {
			ResponseEntity<Iterable<StoreInfo>> responseEntity = storeService.findAllInfo();
			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("items", responseEntity.getBody());
				modelMap.put("pageTitle", "Add notification for store");
			} else {
				modelMap.put("msg", "Server - Get all store for selection result "
						+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				modelMap.put("msgType", "danger");
			}
		} else {
			modelMap.put("pageTitle", "Add notification for all user/store");
		}

		String returnLink = "manager/notification/edit" + editType;

		if (errors.hasErrors()) {
			modelMap.put("title", "Add notification");
			modelMap.put("notificationActive", "active");

			modelMap.put("editType", editType);

			modelMap.put("parentPageTitle", "Notification");

			return returnLink;
		} else {
			ResponseEntity<Void> responseEntity = notificationService.update(item);
			if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
				redirectAttr.addFlashAttribute("msg", "Update success!");
				redirectAttr.addFlashAttribute("msgType", "success");
			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Update notification result " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}

			return "redirect:/manager/notification/index";
		}
	}

	@RequestMapping(value = { "addStore" }, method = RequestMethod.GET)
	public String addStore(ModelMap modelMap) {
		NotificationInfo item = new NotificationInfo();

		modelMap.put("addType", "Store");

		modelMap.put("pageTitle", "Add notification for store");
		modelMap.put("parentPageTitle", "Notification");
		modelMap.put("title", "Add notification");
		modelMap.put("notificationActive", "active");

		ResponseEntity<Iterable<StoreInfo>> responseEntity = storeService.findAllInfo();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("items", responseEntity.getBody());
			modelMap.put("item", item);
		} else {
			modelMap.put("msg", "Server - Get stores result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}

		return "manager/notification/addStore";
	}

	@RequestMapping(value = { "addUser" }, method = RequestMethod.GET)
	public String addUser(ModelMap modelMap) {
		NotificationInfo item = new NotificationInfo();

		modelMap.put("title", "Add notification");
		modelMap.put("notificationActive", "active");
		
		modelMap.put("addType", "User");

		modelMap.put("pageTitle", "Add notification for user");
		modelMap.put("parentPageTitle", "Notification");

		ResponseEntity<Iterable<UserInfo>> responseEntity = userService.findAllInfo();
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("items", responseEntity.getBody());
			modelMap.put("item", item);
		} else {
			modelMap.put("msg", "Server - Get users result "
					+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			modelMap.put("msgType", "danger");
		}

		return "manager/notification/addUser";
	}

	@RequestMapping(value = { "addAll" }, method = RequestMethod.GET)
	public String addAll(ModelMap modelMap) {
		NotificationInfo item = new NotificationInfo();

		modelMap.put("title", "Add notification");
		modelMap.put("notificationActive", "active");

		modelMap.put("addType", "All");

		modelMap.put("item", item);
		modelMap.put("pageTitle", "Add notification for all user/store");
		modelMap.put("parentPageTitle", "Notification");

		return "manager/notification/addAll";
	}

	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
	public String create(@ModelAttribute("item") @Valid NotificationInfo item, BindingResult errors,
			@RequestParam("addType") String addType, ModelMap modelMap,
			RedirectAttributes redirectAttr) {

		if (addType.equals("User")) {
			ResponseEntity<Iterable<UserInfo>> responseEntity = userService.findAllInfo();
			if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
				modelMap.put("items", responseEntity.getBody());
				modelMap.put("pageTitle", "Add notification for user");
			} else {
				modelMap.put("msg", "Server - Get all user for selection result "
						+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				modelMap.put("msgType", "danger");
			}
		} else if (addType.equals("Store")) {
			ResponseEntity<Iterable<StoreInfo>> responseEntity = storeService.findAllInfo();
			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("items", responseEntity.getBody());
				modelMap.put("pageTitle", "Add notification for store");
			} else {
				modelMap.put("msg", "Server - Get all store for selection result "
						+ (responseEntity == null ? "null" : responseEntity.getStatusCode()));
				modelMap.put("msgType", "danger");
			}
		} else {
			modelMap.put("pageTitle", "Add notification for all user/store");
		}

		String returnLink = "manager/notification/add" + addType;

		if (errors.hasErrors()) {
			modelMap.put("title", "Add notification");
			modelMap.put("notificationActive", "active");

			modelMap.put("addType", addType);

			modelMap.put("parentPageTitle", "Notification");

			return returnLink;
		} else {
			ResponseEntity<NotificationInfo> responseEntity2 = notificationService.create(item);

			if (!(responseEntity2 == null || responseEntity2.getStatusCode() != HttpStatus.OK)) {
				redirectAttr.addFlashAttribute("msg", "Add success!");
				redirectAttr.addFlashAttribute("msgType", "success");
			} else {
				redirectAttr.addFlashAttribute("msg", "Server - Add notification result " + (responseEntity2 == null ? "null" : responseEntity2.getStatusCode()));
				redirectAttr.addFlashAttribute("msgType", "danger");
			}

			return "redirect:/manager/notification/index";
		}
	}

	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttr) {
		ResponseEntity<Void> responseEntity = notificationService.delete(id);
		if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
			redirectAttr.addFlashAttribute("msg", "Delete success!");
			redirectAttr.addFlashAttribute("msgType", "success");
		} else {
			redirectAttr.addFlashAttribute("msg", "Server - Delete notification result " + (responseEntity == null ? "null" : responseEntity.getStatusCode()));
			redirectAttr.addFlashAttribute("msgType", "danger");
		}
		return "redirect:/manager/notification/index";
	}
}