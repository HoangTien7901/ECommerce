package com.demo.services.user;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.CartProductInfo;

@Service("cartProductService")
public class CartProductService implements ICartProductService {
	
	private String BASE_URL = "http://localhost:9596/api/cartProduct/";

	@Override
	public ResponseEntity<Iterable<CartProductInfo>> findByCartId(int cartId) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findByCartId/" + cartId,
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<CartProductInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public ResponseEntity<CartProductInfo> findByCartIdAndProductId(int cartId, int productId) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForEntity(BASE_URL + "findByCartIdAndProductId/" + cartId + "/" + productId, CartProductInfo.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<CartProductInfo> create(CartProductInfo _object) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			return restTemplate.postForEntity(BASE_URL + "create", _object, CartProductInfo.class);
		} catch (Exception e) {
			System.out.println("Create object error: " + e.getMessage());
			return new ResponseEntity<CartProductInfo>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Void> updateQuantity(int cartId, int productId, int quantity) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.put(BASE_URL + "updateQuantity/" + cartId + "/" + productId, quantity);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Service error: " + e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Override
	public ResponseEntity<Void> delete(int cartId, int productId) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.delete(BASE_URL + "delete/" + cartId + "/" + productId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
