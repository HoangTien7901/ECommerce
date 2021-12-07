package com.demo.services.user;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.CategoryInfo;

@Service("categoryService")
public class CategoryService implements ICategoryService {

	private String BASE_URL = "http://localhost:9596/api/category/";
	
	@Override
	public ResponseEntity<Iterable<CategoryInfo>> findAll() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findAll",
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<CategoryInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public ResponseEntity<Iterable<CategoryInfo>> findYoungestChildren() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findYoungestChildren",
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<CategoryInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
