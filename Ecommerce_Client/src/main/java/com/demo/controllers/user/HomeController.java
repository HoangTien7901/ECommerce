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
=======
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.helpers.FileUploadHelper;
import com.demo.models.BranchInfo;
import com.demo.models.CategoryInfo;
import com.demo.models.ImageInfo;
import com.demo.models.ProductInfo;
import com.demo.services.BranchService;
import com.demo.services.CategoryService;
import com.demo.services.ImageService;
import com.demo.services.ProductService;

@Controller
@RequestMapping({"","home"})
public class HomeController {
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private BranchService branchService;
	
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

	
	
	
	
	@RequestMapping(value = {"","index"},  method = RequestMethod.GET)
	public String index() {
		return "store.index";
	}
	
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile() {
		return "store.profile";
	}
	
	@RequestMapping(value = "product", method = RequestMethod.GET)
	public String product() {
		return "store.product.index";
	}
	
	@RequestMapping(value = "order", method = RequestMethod.GET)
	public String order() {
		return "store.order.index";
	}
	
	@RequestMapping(value = "product/add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.put("product", new ProductInfo());
		ResponseEntity<List<BranchInfo>> branchEntity = branchService.findAll();
		modelMap.put("branchs", branchEntity.getBody());
		ResponseEntity<List<CategoryInfo>> categoryEntity = categoryService.findAll();
		modelMap.put("categories", categoryEntity.getBody());
		return "store.product.add";
	}
	
	@RequestMapping(value = "product/create", method = RequestMethod.POST)
	public String uploads(@RequestParam("photos") MultipartFile[] photos,HttpServletRequest request) {

		/*
		 * try { //This will decode the String which is encoded by using Base64 class
		 * byte[] imageByte=Base64.decodeBase64(imageValue);
		 * 
		 * String directory=servletContext.getRealPath("/")+"uploads/images/sample.jpg";
		 * 
		 * new FileOutputStream(directory).write(imageByte); return
		 * "redirect:/home/product/add"; } catch(Exception e) { return "error = "+e; }
		 */
		 System.out.println(photos[0].getSize());
		 for (MultipartFile photo : photos) { System.out.println("name: " +
		 photo.getOriginalFilename()); System.out.println("type: " +
		 photo.getContentType()); System.out.println("size: " + photo.getSize());
		 System.out.println("-------------------------"); String fileName =
		 FileUploadHelper.upload(photo, servletContext);
		 
		 if (fileName != null) { System.out.println("file name: " + fileName); } else
		  { System.out.println("Failed"); } }
		   
		  return "redirect:/home/product/add";
		 
	}
	
	/*
	 * @RequestMapping(value = "product/create", method = RequestMethod.POST) public
	 * String add(@ModelAttribute("product") ProductInfo
	 * product, @RequestParam("photos") MultipartFile[] photos) {
	 * 
	 * for (MultipartFile photo : photos) { System.out.println("name: " +
	 * photo.getOriginalFilename()); System.out.println("type: " +
	 * photo.getContentType()); System.out.println("size: " + photo.getSize()); } //
	 * product.setStoreId(1); String avatar = FileUploadHelper.upload(photos[0],
	 * servletContext); //System.out.println("avatar: " + photos.length); if(avatar
	 * != null) { product.setAvatar(avatar); } ResponseEntity<ProductInfo>
	 * responseEntity = productService.create(product); if (responseEntity != null)
	 * { System.out.println("status: " + responseEntity.getStatusCode()); for (int i
	 * = 1; i < photos.length; i++) { String fileName =
	 * FileUploadHelper.upload(photos[i], servletContext);
	 * 
	 * if (fileName != null) { ImageInfo imageInfo = new ImageInfo();
	 * imageInfo.setName(fileName);
	 * imageInfo.setProductId(responseEntity.getBody().getId());
	 * ResponseEntity<ImageInfo> imageResponseEntity =
	 * imageService.create(imageInfo); if(imageResponseEntity == null) { return
	 * "store.product.add"; } System.out.println("file name: " + fileName); } else {
	 * System.out.println("Failed"); return "store.product.add"; } } return
	 * "store.product.index"; } return "store.product.add"; }
	 */
	
	@RequestMapping(value = "product/images", method = RequestMethod.GET)
	public String images() {
		return "store/product/uploadImages2";
	}
}
