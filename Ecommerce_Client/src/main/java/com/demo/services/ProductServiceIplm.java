package com.demo.services;

import java.util.List;

import org.json.HTTP;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.demo.models.ProductInfo;

@Service("productService")
public class ProductServiceIplm implements ProductService {
	
	private String BASE_URL = "http://localhost:9596/api/product/";	

	@Override
	public ResponseEntity<List<ProductInfo>> findByStore(int storeId) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findByStore/" + storeId, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<ProductInfo>>() {
					});
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ResponseEntity<Boolean> delete(int id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.delete(BASE_URL + "delete/" + id);
			return new ResponseEntity<Boolean>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Boolean> deleteListProduct(List<Integer> ids) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.delete(BASE_URL + "deleteListProduct/" + ids);
			return ResponseEntity.noContent().build();  
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<ProductInfo> create(ProductInfo product) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.postForEntity(BASE_URL + "create", product, ProductInfo.class);
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
