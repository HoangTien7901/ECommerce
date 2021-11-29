package com.demo.services.manager;

import java.util.Date;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.UserInfo;

@Service("manager/userService")
public class UserService implements IUserService {

	private String BASE_URL = "http://localhost:9596/api/manager/user/";

	@Override
	public ResponseEntity<Iterable<UserInfo>> findAllInfo() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findAll",
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<UserInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public ResponseEntity<Iterable<UserInfo>> findAllInfoActive() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findAllActive",
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<UserInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<UserInfo> findInfoById(int id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForEntity(BASE_URL + "findInfoById/" + id, UserInfo.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<UserInfo> create(UserInfo object) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			return restTemplate.postForEntity(BASE_URL + "create", object, UserInfo.class);
		} catch (Exception e) {
			System.out.println("Create object error: " + e.getMessage());
			return new ResponseEntity<UserInfo>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Void> update(UserInfo object) {
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
