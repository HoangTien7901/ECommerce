package com.demo.services;

import java.util.List;

import org.json.HTTP;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.demo.models.ProductInfo;
import com.demo.models.TransactionInfo;

@Service("transactionService")
public class TransactionServiceIplm implements TransactionService {
	
	private String BASE_URL = "http://localhost:9596/api/transaction/";	

	@Override
	public ResponseEntity<List<TransactionInfo>> findAllOrder() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findall/order", HttpMethod.GET, null,
					new ParameterizedTypeReference<List<TransactionInfo>>() {
					});
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ResponseEntity<List<TransactionInfo>> findAllService() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findall/service", HttpMethod.GET, null,
					new ParameterizedTypeReference<List<TransactionInfo>>() {
					});
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ResponseEntity<TransactionInfo> save(TransactionInfo transaction) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.postForEntity(BASE_URL + "create", transaction, TransactionInfo.class);
		} catch (Exception e) {
			return null;
		}
	}
	
}
