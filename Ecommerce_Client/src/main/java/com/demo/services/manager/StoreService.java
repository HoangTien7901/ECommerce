package com.demo.services.manager;

import java.util.Date;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.StoreInfo;

@Service("manager/storeService")
public class StoreService implements IStoreService {

	private String BASE_URL = "http://localhost:9596/api/manager/store/";

	@Override
	public ResponseEntity<Iterable<StoreInfo>> findAllInfo() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findAll",
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<StoreInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public ResponseEntity<Iterable<StoreInfo>> findAllInfoActive() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findAllActive",
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<StoreInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<StoreInfo> findInfoById(int id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForEntity(BASE_URL + "findInfoById/" + id, StoreInfo.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<StoreInfo> create(StoreInfo object) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			return restTemplate.postForEntity(BASE_URL + "create", object, StoreInfo.class);
		} catch (Exception e) {
			System.out.println("Create object error: " + e.getMessage());
			return new ResponseEntity<StoreInfo>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Void> update(StoreInfo object) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.put(BASE_URL + "update/" + object.getId(), object);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Void> delete(int id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.delete(BASE_URL + "delete/" + id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Override
	public ResponseEntity<Void> toggleStatus(int id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.put(BASE_URL + "toggleStatus/" + id, null);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Override
	public ResponseEntity<Void> updateBanTerm(int id, String banTerm) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.put(BASE_URL + "updateBanTerm/" + id, banTerm);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
