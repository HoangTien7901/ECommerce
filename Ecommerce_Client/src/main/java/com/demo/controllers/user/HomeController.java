package com.demo.controllers.user;

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
