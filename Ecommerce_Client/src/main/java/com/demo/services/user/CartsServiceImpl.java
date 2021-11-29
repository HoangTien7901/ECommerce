package com.demo.services.user;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.entities.Carts;
import com.demo.models.CartsInfor;
import com.demo.models.Products;

@Service("cartsSerivce")
public class CartsServiceImpl implements CartsSerivce {

	private String BASE_URL = "http://localhost:9090/api/cart/";

	@Override
	public ResponseEntity<List<CartsInfor>> findAll() {
		try {

			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findall",
					HttpMethod.GET ,
					null , 
					new ParameterizedTypeReference<List<CartsInfor>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<Carts> create(Carts carts) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.postForEntity(BASE_URL + "create", carts, Carts.class);

		} catch (Exception e) {
			return null;
		}
	}

	
	
	
}
