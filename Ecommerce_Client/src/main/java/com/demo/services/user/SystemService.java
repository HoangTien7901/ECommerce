package com.demo.services.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("systemService")
public class SystemService implements ISystemService {
	
	private String BASE_URL = "http://localhost:9596/api/system/";
	
	@Override
	public ResponseEntity<com.demo.models.System> getSystem() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForEntity(BASE_URL + "getSystem", com.demo.models.System.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
