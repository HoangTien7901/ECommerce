package com.demo.controllers.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.models.ProductInfo;
import com.demo.services.BranchService;
import com.demo.services.ProductService;

@Controller
@RequestMapping(value = {"product" })
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private BranchService branchService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "store/product/index2";
	}
	
	@RequestMapping(value = "findByStore/{storeId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<ProductInfo> getAllEmployee(@PathVariable("storeId") int storeId) {
 
		ResponseEntity<List<ProductInfo>> responseEntity = productService.findByStore(storeId);
 
		return responseEntity.getBody();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Boolean delete(@RequestParam("id") int id) {
 
		ResponseEntity<Boolean> responseEntity = productService.delete(id);
 
		return responseEntity.getBody();
	}
	
	@RequestMapping(value = "/deleteListProduct/{ids}", method = RequestMethod.DELETE, produces = "application/json")	
	public @ResponseBody int deleteListProduct(@PathVariable List<Integer> ids) {
 
		System.out.println(ids);
		ResponseEntity<Boolean> responseEntity = productService.deleteListProduct(ids);
 
		return responseEntity.getStatusCodeValue();
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ProductInfo create(@ModelAttribute("product") @Valid ProductInfo product, BindingResult errors ) {
 
		/*
		 * employeeValidator.validate(employee, errors); if(errors.hasErrors()) { return
		 * "employee/register"; }else { return "employee/success"; }
		 */
		//ResponseEntity<ProductInfo> responseEntity = productService.findAll();
		
		return new ProductInfo();
	}
	

}
