package com.demo.services.user;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.Products;

@Service("searchService")
public class SearchServiceImpl implements SearchService{

	private String BASE_URL = "http://localhost:9090/api/search/";

	@Override
	public ResponseEntity<List<Products>> searchByKeyword(String product) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "searchs/" + product,
					HttpMethod.GET ,
					null , 
					new ParameterizedTypeReference<List<Products>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<List<Products>> searchbyMinMax(double min, double max) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "searchs/" + min + "/" + max,
					HttpMethod.GET ,
					null , 
					new ParameterizedTypeReference<List<Products>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
}
