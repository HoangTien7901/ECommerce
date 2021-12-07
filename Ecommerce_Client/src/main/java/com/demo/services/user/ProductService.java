package com.demo.services.user;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.ProductInfo;

@Service("productService")
public class ProductService implements IProductService {

	private String BASE_URL = "http://localhost:9596/api/product/";

	@Override
	public ResponseEntity<Iterable<ProductInfo>> findAllInfo() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findAllActive",
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<ProductInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	

	@Override
	public ResponseEntity<Iterable<ProductInfo>> findBestSelling() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findBestSelling",
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<ProductInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}



	@Override
	public ResponseEntity<Iterable<ProductInfo>> findOutStanding() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findOutStanding",
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<ProductInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<Iterable<ProductInfo>> searchWithCategory(String keyword, double min, double max,
			int categoryId) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "searchWithCategory/" + keyword + "/" + min + "/" + max + "/" + categoryId,
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<ProductInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<Iterable<ProductInfo>> search(String keyword, double min, double max) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "search/" + keyword + "/" + min + "/" + max,
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<ProductInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<ProductInfo> findInfoById(int id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForEntity(BASE_URL + "findInfoById/" + id, ProductInfo.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<Void> update(ProductInfo object) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.put(BASE_URL + "update/" + object.getId(), object);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Service error: " + e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

}
