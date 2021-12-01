package com.demo.services.user;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.Products;
import com.demo.models.UserId;

@Service("userService")
public class UserServiceImpl implements UserService {

	private String BASE_URL = "http://localhost:9090/api/user/";
	
	@Override
	public ResponseEntity<UserId> getIdUser() {
		try {

			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "getuser",
					HttpMethod.GET ,
					null , 
					new ParameterizedTypeReference<UserId>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
