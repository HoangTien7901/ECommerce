package com.demo.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.ProductInfo;
import com.demo.services.manager.IProductService;

@RestController
@RequestMapping("api/manager/product")
public class ProductRestController {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<ProductInfo>> findAllInfo() {
		try {
			return new ResponseEntity<Iterable<ProductInfo>>(productService.findAllInfo(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<ProductInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findInfoById/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductInfo> findInfoUserById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<ProductInfo>(productService.findInfoById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ProductInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"update/{id}"} , method = RequestMethod.PUT,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE , 
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductInfo> update(@PathVariable("id") int id, @RequestBody ProductInfo object) {
		try {
			return new ResponseEntity<ProductInfo>(productService.update(id, object), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ProductInfo>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"toggleStatus/{id}"} , method = RequestMethod.PUT)
	public ResponseEntity<Void> toggleStatus(@PathVariable("id") int id) {
		try {
			int result = productService.toggleStatus(id);
			
			if (result == 0) {
				throw new Exception("Toggle store status failed : No row affected.");
			}
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"updateBanReason/{id}"} , method = RequestMethod.PUT,
			consumes = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<Void> updateBanReason(@PathVariable("id") int id, @RequestBody String banReason) {
		try {
			int result = 0;
			if (banReason.equals("tmp")) {
				result = productService.updateBanReason(id, null);
			} else {
				result = productService.updateBanReason(id, banReason);
			}
			
			if (result == 0) {
				throw new Exception("Toggle store status failed : No row affected.");
			}
			
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value= {"delete/{id}"} , method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		try {
			productService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
