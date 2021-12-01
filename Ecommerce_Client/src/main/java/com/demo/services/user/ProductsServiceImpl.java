package com.demo.services.user;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.Products;

@Service("productsService")
public class ProductsServiceImpl implements ProductsService {

	private String BASE_URL = "http://localhost:9090/api/product/";
	
	@Override
	public ResponseEntity<List<Products>> findAll() {
		try {

			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findall",
					HttpMethod.GET ,
					null , 
					new ParameterizedTypeReference<List<Products>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<Products> findProductById(int id) {
		try {

			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "find/" + id,
					HttpMethod.GET ,
					null , 
					new ParameterizedTypeReference<Products>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<List<Products>> bestSell() {
		try {

			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "bestsell",
					HttpMethod.GET ,
					null , 
					new ParameterizedTypeReference<List<Products>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<List<Products>> topProduct() {
		try {

			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "topproduct",
					HttpMethod.GET ,
					null , 
					new ParameterizedTypeReference<List<Products>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<com.demo.entities.Products> findById(int id) {
		try {

			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "search/" + id,
					HttpMethod.GET ,
					null , 
					new ParameterizedTypeReference<com.demo.entities.Products>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}


	
	
}
