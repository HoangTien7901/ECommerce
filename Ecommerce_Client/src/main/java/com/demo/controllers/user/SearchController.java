package com.demo.controllers.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.models.CategoryInfor;
import com.demo.models.Products;
import com.demo.services.user.CategoryService;
import com.demo.services.user.ProductsService;
import com.demo.services.user.SearchService;

@Controller
@RequestMapping(value = { "search" })
public class SearchController {

	@Autowired
	private SearchService searchService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "searchkeyword" }, method = RequestMethod.GET)
	public String total(ModelMap modelMap, @RequestParam("keyword") String keyword) {

		ResponseEntity<List<Products>> responseEntity = searchService.searchByKeyword(keyword);
		if (responseEntity != null) {
			// System.out.println("Status : " + responseEntity.getStatusCodeValue());
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				List<Products> products = (List<Products>) responseEntity.getBody();
				System.out.println("Result : " + products.size());
				int quantities = products.size();

				modelMap.put("quantity", quantities);
				modelMap.put("produ", products);
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

		return "user/searchs/index";
	}

	@RequestMapping(value = { "searchbyminmax" }, method = RequestMethod.GET)
	public String searchByMinMax(ModelMap modelMap, @RequestParam("min") double min, @RequestParam("max") double max) {

		if (min == 0) {
			modelMap.put("msg", "Min is not Null");
		} else if (max == 0) {
			modelMap.put("msg", "Max is not Null");
		} else {
			ResponseEntity<List<Products>> responseEntity = searchService.searchbyMinMax(min, max);
			if (responseEntity != null) {
				// System.out.println("Status : " + responseEntity.getStatusCodeValue());
				if (responseEntity.getStatusCode() == HttpStatus.OK) {
					List<Products> products = (List<Products>) responseEntity.getBody();
					System.out.println("Result : " + products.size());
					int quantities = products.size();

					modelMap.put("quantity", quantities);
					modelMap.put("produ", products);
				}
			}
		}

		return "user/searchs/index";
	}
	
	@RequestMapping(value = { "category/{ids}" }, method = RequestMethod.GET)
	public String getProductbyCategory(ModelMap modelMap, @PathVariable("ids") int ids) {

		
			ResponseEntity<List<Products>> responseEntity = searchService.getProductbyCategory(ids);
			if (responseEntity != null) {
				// System.out.println("Status : " + responseEntity.getStatusCodeValue());
				if (responseEntity.getStatusCode() == HttpStatus.OK) {
					List<Products> products = (List<Products>) responseEntity.getBody();
					System.out.println("Result : " + products.size());
					int quantities = products.size();

					modelMap.put("quantity", quantities);
					modelMap.put("produ", products);
				}
			}
		return "user/searchs/index";
	}


}
