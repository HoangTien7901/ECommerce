package com.demo.services.manager;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.TagInfo;
import com.demo.models.TransactionInfo;

@Service("manager/transactionService")
public class TransactionService implements ITransactionService {
	
	private String BASE_URL = "http://localhost:9596/api/manager/transaction/";

	@Override
	public ResponseEntity<Iterable<TransactionInfo>> findAllInfo() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findAll",
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<TransactionInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public ResponseEntity<Iterable<TransactionInfo>> findAllServiceInfo() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findAllService",
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<TransactionInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public ResponseEntity<Iterable<TransactionInfo>> findAllProductInfo() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findAllProduct",
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<TransactionInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
