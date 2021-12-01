package com.demo.services.user;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.CategoryInfor;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	private String BASE_URL = "http://localhost:9090/api/category/";
	
	@Override
	public ResponseEntity<List<CategoryInfor>> getAll() {
		try {

			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findall",
					HttpMethod.GET ,
					null , 
					new ParameterizedTypeReference<List<CategoryInfor>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<List<CategoryInfor>> getParent(int id) {
		try {

			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "parent/" + id,
					HttpMethod.GET ,
					null , 
					new ParameterizedTypeReference<List<CategoryInfor>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}



}
