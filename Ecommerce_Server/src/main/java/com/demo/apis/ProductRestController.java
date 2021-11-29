package com.demo.apis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Branchs;
import com.demo.entities.Categories;
import com.demo.entities.Products;
import com.demo.entities.Stores;
import com.demo.models.BranchInfo;
import com.demo.models.CategoryInfo;
import com.demo.models.ProductInfo;
import com.demo.models.StoreInfo;
import com.demo.services.user.*;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private BranchService branchService;
	@Autowired
	private StoreService storeService;

	@RequestMapping(value = "findByStore/{storeId}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<ProductInfo>> findByStoreId(@PathVariable("storeId") int storeId) {
		try {
			return new ResponseEntity<Iterable<ProductInfo>>(productService.findByStoreId(storeId), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Iterable<ProductInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> delete(@RequestParam("id") int id) {
		try {
			return new ResponseEntity<Boolean>(productService.delete(id), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "deleteListProduct/[{ids}]", method = RequestMethod.DELETE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Boolean> deleteListProduct(@PathVariable String[] ids) {
		try {
			List<Integer> result = new ArrayList<Integer>();
			for (String id : ids) {
				result.add(Integer.parseInt(id));
			}
			return new ResponseEntity<Boolean>(productService.delete(result), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Products> create(@RequestBody ProductInfo product) {
		try {
			Products products = new Products();
			products.setAvatar(product.getAvatar());
			//Branchs
			BranchInfo branchInfo = branchService.find(product.getBranchId());
			Branchs branchs = new Branchs();
			branchs.setId(product.getBranchId());
			branchs.setName(branchInfo.getName());
			branchs.setLogo(branchInfo.getLogo());
			products.setBranchs(branchs);
			//Branchs
			//Category
			CategoryInfo categoryInfo = categoryService.find(product.getCategoryId());
			Categories category = new Categories();
			category.setId(categoryInfo.getId());
			category.setName(categoryInfo.getName());
			category.setLevel(categoryInfo.getLevel());
			category.setStatus(true);
			category.setDiscountPercent(categoryInfo.getDiscountPercent());
			//Category
			//Parent Category
			Categories parentCategory = new Categories();
			CategoryInfo paretnCategoryInfo = categoryService.find(categoryInfo.getParentId());
			parentCategory.setId(paretnCategoryInfo.getId());
			parentCategory.setName(paretnCategoryInfo.getName());
			parentCategory.setLevel(paretnCategoryInfo.getLevel());
			parentCategory.setStatus(true);
			parentCategory.setDiscountPercent(paretnCategoryInfo.getDiscountPercent());
			parentCategory.setCategories(parentCategory);
			//Parent Category
			products.setCategories(category);
			products.setCreated(new Date());
			products.setDescription(product.getDescription());
			products.setDescriptionDetail(product.getDescriptionDetail());
			products.setDiscountAmount(product.getDiscountAmount());
			products.setDiscountPercent(product.getDiscountPercent());
			products.setInventory(product.getQuantity());
			products.setQuantity(product.getQuantity());
			products.setIsBestSelling(product.getIsBestSelling());
			products.setIsLocked(product.getIsLocked());
			products.setIsNew(product.getIsNew());
			products.setIsOutstanding(product.getIsOutstanding());
			products.setPrice(product.getPrice());
			products.setOriginalPrice(product.getOriginalPrice());
			products.setRatingAverage(product.getRatingAverage());
			products.setRatingCount(product.getRatingCount());
			products.setSaleOffPercent(product.getSaleOffPercent());
			products.setStatus(product.isStatus());
			products.setName(product.getName());
			//Stores
			StoreInfo storeInfo = storeService.find(product.getStoreId());
			Stores store = new Stores();
			store.setId(storeInfo.getId());
			store.setAddress(storeInfo.getAddress());
			store.setBanTerm(storeInfo.getBanTerm());
			store.setCreated(storeInfo.getCreated());
			store.setEmail(storeInfo.getEmail());
			store.setExpiry(storeInfo.getExpiry());
			store.setLogo(storeInfo.getLogo());
			store.setName(storeInfo.getName());
			store.setPhone(storeInfo.getPhone());
			store.setStatus(storeInfo.isStatus());
			store.setUpdated(storeInfo.getUpdated());
			//Stores
			products.setStores(store);
			return new ResponseEntity<Products>(productService.create(products), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Products>(HttpStatus.BAD_REQUEST);
		}
	}

}
