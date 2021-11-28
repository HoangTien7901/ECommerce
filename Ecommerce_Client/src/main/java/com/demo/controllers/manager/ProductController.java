package com.demo.controllers.manager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.demo.helpers.FileUploadHelper;
import com.demo.helpers.MailHelper;
import com.demo.models.BranchInfo;
import com.demo.models.CategoryInfo;
import com.demo.models.ProductInfo;
import com.demo.models.StoreInfo;
import com.demo.services.manager.IBranchService;
import com.demo.services.manager.ICategoryService;
import com.demo.services.manager.IProductService;
import com.demo.services.manager.IStoreService;

@Controller
@RequestMapping("manager/product")
public class ProductController implements ServletContextAware {

	private ServletContext servletContext;

	@Autowired
	private IProductService productService;
	
	@Autowired
	private IStoreService storeService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IBranchService branchService;

	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		
		ResponseEntity<Iterable<ProductInfo>> responseEntity = productService.findAllInfo();
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				modelMap.put("title", "Manage product");
				modelMap.put("productActive", "active");

				modelMap.put("items", responseEntity.getBody());
				modelMap.put("pageTitle", "Product list");
				modelMap.put("parentPageTitle", "Product");
			}
		}
		return "manager/product/index";
	}

	@RequestMapping(value = { "edit/{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		ResponseEntity<ProductInfo> responseEntity = productService.findInfoById(id);

		ProductInfo result = responseEntity.getBody();

		ResponseEntity<Iterable<StoreInfo>> storeRespone = storeService.findAllInfo();
		ResponseEntity<Iterable<CategoryInfo>> categoryRespone = categoryService.findAllInfo();
		ResponseEntity<Iterable<BranchInfo>> branchRespone = branchService.findAllInfo();
		
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
			if (storeRespone != null && storeRespone.getStatusCode() == HttpStatus.OK) {
				if (categoryRespone != null && categoryRespone.getStatusCode() == HttpStatus.OK) {
					if (branchRespone != null && branchRespone.getStatusCode() == HttpStatus.OK) {
						modelMap.put("stores", storeRespone.getBody());
						modelMap.put("categories", categoryRespone.getBody());
						modelMap.put("branches", branchRespone.getBody());
						
						modelMap.put("title", "Edit product");
						modelMap.put("productActive", "active");

						modelMap.put("img", result.getAvatar());
						modelMap.put("item", result);
						modelMap.put("pageTitle", "Edit");
						modelMap.put("parentPageTitle", "Product");
					} else {
						System.out.println("Client - Update get branches result" + responseEntity == null ? "null"
								: responseEntity.getStatusCode());
					}
				} else {
					System.out.println("Client - Update get categories result" + responseEntity == null ? "null"
							: responseEntity.getStatusCode());
				}
			} else {
				System.out.println("Client - Update get stores result" + responseEntity == null ? "null"
						: responseEntity.getStatusCode());
			}
		} else {
			System.out.println("Client - Update get product result" + responseEntity == null ? "null"
					: responseEntity.getStatusCode());
		}
		return "manager/product/edit";
	}
	
	@RequestMapping(value = { "lock/{id}" }, method = RequestMethod.GET)
	public String lock(@PathVariable("id") int id, ModelMap modelMap) {
		ResponseEntity<ProductInfo> responseEntity = productService.findInfoById(id);

		ProductInfo result = responseEntity.getBody();
		
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
			modelMap.put("title", "Lock product");
			modelMap.put("productActive", "active");

			modelMap.put("id", result.getId());
			modelMap.put("productName", result.getName());
			modelMap.put("pageTitle", "Lock");
			modelMap.put("parentPageTitle", "Product");
		} else {
			System.out.println("Client - Update get product result" + responseEntity == null ? "null"
					: responseEntity.getStatusCode());
		}
		return "manager/product/lock";
	}
	
	@RequestMapping(value = { "lock" }, method = RequestMethod.POST)
	public String lock(@RequestParam("banReason") String banReason, @RequestParam("id") int id) {
		
		ResponseEntity<Void> responseEntity = productService.toggleStatus(id);
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
			responseEntity = productService.updateBanReason(id, banReason);
			
			if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
				
			} else {
				System.out.println("Client - Update lock product(ban reason) result" + responseEntity == null ? "null"
						: responseEntity.getStatusCode());
			}
		} else {
			System.out.println("Client - Update lock product(status) result" + responseEntity == null ? "null"
					: responseEntity.getStatusCode());
		}
		return "redirect:/manager/product/index";
	}

	@RequestMapping(value = { "save" }, method = RequestMethod.POST)
	public String save(@ModelAttribute("item") ProductInfo item, @RequestParam("newAvatar") MultipartFile newAvatar) {		
		// upload new avatar
		if (!newAvatar.isEmpty()) {
			try {
				// delete old image
			    Path fileToDeletePath = Paths.get("src/main/webapp/uploads/images/" + item.getAvatar());
			    Files.delete(fileToDeletePath);
			    
			    String fileName = FileUploadHelper.upload(newAvatar, servletContext);
				item.setAvatar(fileName); 
			} catch (Exception e) {
				System.out.println("Delete old product's avatar error: " + e.getMessage());
			}
		}
		
		ResponseEntity<Void> responseEntity = productService.update(item);
		if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
			
//			send out notification
		} else {
			System.out.println("Client - Update product result" + responseEntity == null ? "null"
					: responseEntity.getStatusCode());
		}

		return "redirect:/manager/product/index";
	}

	@RequestMapping(value = { "delete/{id}" }, method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		ResponseEntity<Void> responseEntity = productService.delete(id);
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {

			} else {

			}
		}
		return "redirect:/manager/product/index";
	}
	
	@RequestMapping(value = { "toggleStatus/{id}" }, method = RequestMethod.GET)
	public String toggleStatus(@PathVariable("id") int id) {
		ResponseEntity<Void> responseEntity = productService.toggleStatus(id);
		if (responseEntity != null) {
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				// just send some temporary text to make it not null
				responseEntity = productService.updateBanReason(id, "tmp");
				
				if (responseEntity != null && responseEntity.getStatusCode() == HttpStatus.OK) {
					
				} else {
					System.out.println("Client - Update lock product(ban reason) result" + responseEntity == null ? "null"
							: responseEntity.getStatusCode());
				}
			} else {

			}
		}
		return "redirect:/manager/product/index";
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
}