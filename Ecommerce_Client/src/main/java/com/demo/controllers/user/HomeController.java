package com.demo.controllers.user;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.CartsInfor;
import com.demo.models.CategoryInfor;
import com.demo.models.Images;
import com.demo.models.Products;
import com.demo.models.UserId;
import com.demo.services.user.CategoryService;
import com.demo.services.user.ImagesService;
import com.demo.services.user.ProductsService;
import com.demo.services.user.UserService;

@Controller
@RequestMapping(value = { "", "home" })
public class HomeController {

	@Autowired
	private ProductsService productsService;

	@Autowired
	private ImagesService imagesService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ResponseEntity<List<Products>> responseEntity = productsService.findAll();
		
		if (responseEntity != null) {
			System.out.println("Status : " + responseEntity.getStatusCodeValue());
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				List<Products> findall = (List<Products>) responseEntity.getBody();
				System.out.println("Result : " + findall.size());
				
				modelMap.put("findall", findall);
			}
		}
		
		ResponseEntity<UserId> responeUserId = userService.getIdUser();
		if (responeUserId != null) {
			System.out.println("Status : " + responeUserId.getStatusCodeValue());
			if (responeUserId.getStatusCode() == HttpStatus.OK) {
				UserId userid = (UserId) responeUserId.getBody();
				
				modelMap.put("userid", userid);
			}
		}
		
		ResponseEntity<List<Products>> responseEntiti = productsService.bestSell();
		if (responseEntiti != null) {
			System.out.println("Status : " + responseEntiti.getStatusCodeValue());
			if (responseEntiti.getStatusCode() == HttpStatus.OK) {
				List<Products> bestsells = (List<Products>) responseEntiti.getBody();
				System.out.println("Result : " + bestsells.size());
				
				modelMap.put("bestsell", bestsells);
			}
		}
		
		ResponseEntity<List<CategoryInfor>> responseCategory = categoryService.getAll();
		if (responseCategory != null) {
			System.out.println("Status : " + responseCategory.getStatusCodeValue());
			if (responseCategory.getStatusCode() == HttpStatus.OK) {
				List<CategoryInfor> getallCategory = (List<CategoryInfor>) responseCategory.getBody();
				System.out.println("Result : " + getallCategory.size());
				
				modelMap.put("catego", getallCategory);
			}
		}
		
		ResponseEntity<List<CategoryInfor>> responseParent1 = categoryService.getParent(1);
		if (responseParent1 != null) {
			System.out.println("Status : " + responseParent1.getStatusCodeValue());
			if (responseParent1.getStatusCode() == HttpStatus.OK) {
				List<CategoryInfor> getparent1 = (List<CategoryInfor>) responseParent1.getBody();
				System.out.println("Result parent 1 : " + getparent1.size());
				
				modelMap.put("parent1", getparent1);
			}
		}
		
		ResponseEntity<List<CategoryInfor>> responseParent2 = categoryService.getParent(2);
		if (responseParent2 != null) {
			System.out.println("Status : " + responseParent2.getStatusCodeValue());
			if (responseParent2.getStatusCode() == HttpStatus.OK) {
				List<CategoryInfor> getparent2 = (List<CategoryInfor>) responseParent2.getBody();
				System.out.println("Result Parent 2 : " + getparent2.size());
				
				modelMap.put("parent2", getparent2);
			}
		}
		
		ResponseEntity<List<CategoryInfor>> responseParent3 = categoryService.getParent(9);
		if (responseParent3 != null) {
			System.out.println("Status : " + responseParent3.getStatusCodeValue());
			if (responseParent3.getStatusCode() == HttpStatus.OK) {
				List<CategoryInfor> getparent3 = (List<CategoryInfor>) responseParent3.getBody();
				System.out.println("Result Parent 3 : " + getparent3.size());
				
				modelMap.put("parent3", getparent3);
			}
		}
		
		return "user/home/index";
	}
	
	
	

	@RequestMapping(value = "product/{id}", method = RequestMethod.GET)
	public String find(ModelMap modelMap, @PathVariable("id") int id) {
		ResponseEntity<Products> responseEntity = productsService.findProductById(id);
		ResponseEntity<List<Images>> findImage = imagesService.imageById(id);
		if (responseEntity != null) {
			System.out.println("Status Product : " + responseEntity.getStatusCodeValue());

			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				Products find = (Products) responseEntity.getBody();

				modelMap.put("product", find);
			}
		}
		if (findImage != null) {
			System.out.println("Status image : " + findImage.getStatusCodeValue());
			if (findImage.getStatusCode() == HttpStatus.OK) {
				List<Images> findImages = (List<Images>) findImage.getBody();
				System.out.println("Result : " + findImages.size());
				modelMap.put("imageProduct", findImages);
			}
		}
		return "user/productdetails/index";
	}

	
	
	
	
}
