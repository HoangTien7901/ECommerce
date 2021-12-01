package com.demo.services.user;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.CartsInfor;
import com.demo.models.Images;

@Service("imagesService")
public class ImagesServiceImpl implements ImagesService {

	private String BASE_URL = "http://localhost:9090/api/image/";
	
	@Override
	public ResponseEntity<List<Images>> imageById(int id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "find/" + id,
					HttpMethod.GET ,
					null , 
					new ParameterizedTypeReference<List<Images>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
