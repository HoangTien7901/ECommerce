package com.demo.services.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.TransactionDetailsInfo;

@Service("transactionDetailsService")
public class TransactionDetailsService implements ITransactionDetailsService {

	private String BASE_URL = "http://localhost:9596/api/transactionDetails/";

	@Override
	public ResponseEntity<TransactionDetailsInfo> create(TransactionDetailsInfo _object) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			return restTemplate.postForEntity(BASE_URL + "create", _object, TransactionDetailsInfo.class);
		} catch (Exception e) {
			System.out.println("Create transactin details object error: " + e.getMessage());
			return new ResponseEntity<TransactionDetailsInfo>(HttpStatus.BAD_REQUEST);
		}
	}

}
