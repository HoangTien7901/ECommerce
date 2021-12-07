package com.demo.services.user;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.ProductInfo;
import com.demo.models.TransactionDetailsInfo;
import com.demo.models.TransactionInfo;

@Service("userTransactionService")
public class TransactionService implements ITransactionService {

	private String BASE_URL = "http://localhost:9596/api/transaction/";

	@Override
	public ResponseEntity<Iterable<TransactionInfo>> findAllByUserId(int userId) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findAllByUserId/" + userId,
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<TransactionInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<TransactionInfo> create(TransactionInfo _object) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			return restTemplate.postForEntity(BASE_URL + "create", _object, TransactionInfo.class);
		} catch (Exception e) {
			System.out.println("Create transactin object error: " + e.getMessage());
			return new ResponseEntity<TransactionInfo>(HttpStatus.BAD_REQUEST);
		}
	}

	
	
}
