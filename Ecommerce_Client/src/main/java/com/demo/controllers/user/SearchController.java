package com.demo.controllers.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.models.CategoryInfo;
import com.demo.models.ProductInfo;
import com.demo.services.user.ICategoryService;
import com.demo.services.user.IProductService;

@Controller
@RequestMapping(value = "user/search")
public class SearchController {

	@Autowired
	private IProductService productService;

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = { "index", "index/{categoryId}" }, method = RequestMethod.GET)
	public String index(@RequestParam(name = "keyword", required = false) String keyword,
			@PathVariable(name = "categoryId", required = false) String categoryId, ModelMap modelMap,
			HttpServletRequest request, RedirectAttributes redirectAttr) {
		HttpSession session = request.getSession();
		
		// ============= getting store and contact info
		modelMap.put("store", session.getAttribute("store"));
		modelMap.put("contact", session.getAttribute("contact"));

		modelMap.put("hideTopSearchBar", true);

		if (keyword == null || keyword.isEmpty()) {
			keyword = "tmp";
		}

		String message = "";

		ResponseEntity<Iterable<CategoryInfo>> response = categoryService.findYoungestChildren();
		if (!(response == null || response.getStatusCode() != HttpStatus.OK)) {
			modelMap.put("categories", response.getBody());
		} else {
			message += "Server - Get categories result " + (response == null ? null : response.getStatusCode()) + "\n";
		}

		ResponseEntity<Iterable<ProductInfo>> response1;
		if (categoryId != null && !categoryId.isEmpty()) {
			response1 = productService.searchWithCategory("tmp", 0, 999999, Integer.parseInt(categoryId));
		} else {
			response1 = productService.search(keyword, 0, 999999);
		}
		if (!(response1 == null || response1.getStatusCode() != HttpStatus.OK)) {
			if (response1.getBody() != null) {
				List<ProductInfo> products = (List<ProductInfo>) response1.getBody();
				if (products.size() == 0) {
					redirectAttr.addFlashAttribute("msg", "Can't find any product in this category.");
					redirectAttr.addFlashAttribute("msgType", "danger");
					return "redirect:/user/home/index";
				}
			}
			modelMap.put("products", response1.getBody());
		} else {
			message += "Server - Search products by keyword result "
					+ (response1 == null ? null : response1.getStatusCode()) + "\n";
		}

		if (!message.isEmpty()) {
			modelMap.put("msg", message);
			modelMap.put("msgType", "danger");
		}

		return "user/search/index";
	}

	@RequestMapping(value = { "search/{keyword}/{min}/{max}" }, method = RequestMethod.GET)
	public ResponseEntity search(@PathVariable("keyword") String keyword, @PathVariable("min") double min,
			@PathVariable("max") double max) {
		try {
			ResponseEntity<Iterable<ProductInfo>> response = productService.search(keyword, min, max);
			if (!(response == null || response.getStatusCode() != HttpStatus.OK)) {
				return new ResponseEntity<Iterable<ProductInfo>>(response.getBody(), HttpStatus.OK);
			} else {
				throw new Exception(
						"Server - Search product result " + (response == null ? "null" : response.getStatusCode()));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@RequestMapping(value = { "search/{keyword}/{min}/{max}/{categoryId}" }, method = RequestMethod.GET)
	public ResponseEntity search(@PathVariable("keyword") String keyword, @PathVariable("min") double min,
			@PathVariable("max") double max, @PathVariable("categoryId") int categoryId) {
		try {
			ResponseEntity<Iterable<ProductInfo>> response = productService.searchWithCategory(keyword, min, max,
					categoryId);
			if (!(response == null || response.getStatusCode() != HttpStatus.OK)) {
				return new ResponseEntity<Iterable<ProductInfo>>(response.getBody(), HttpStatus.OK);
			} else {
				throw new Exception("Server - Search product with category result "
						+ (response == null ? "null" : response.getStatusCode()));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
