package com.demo.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Banners;
import com.demo.entities.Images;
import com.demo.entities.Products;
import com.demo.models.ImageInfo;
import com.demo.services.user.ImageService;

@RestController
@RequestMapping("/api/image")
public class ImageRestController {
	
	@Autowired
	private ImageService imageService;

	@RequestMapping(value = "create", method = RequestMethod.POST, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Images> create(@RequestBody ImageInfo imageInfo) {
		try {
			Images image = new Images();
			image.setName(imageInfo.getName());
			Products product = new Products();
			product.setId(imageInfo.getProductId());
			image.setProducts(product);
			
			Banners banner = new Banners();
			banner.setId(imageInfo.getBannerId());
			//image.setBanners(banner);
			return new ResponseEntity<Images>(imageService.create(image), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Images>(HttpStatus.BAD_REQUEST);
		}
	}
}
