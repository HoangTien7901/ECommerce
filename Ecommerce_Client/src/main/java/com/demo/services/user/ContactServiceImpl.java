package com.demo.services.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.entities.Contacts;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	private String BASE_URL = "http://localhost:9090/api/contact/";

	@Override
	public ResponseEntity<Void> save(Contacts contacts) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForEntity(BASE_URL + "save" , contacts , Contacts.class );
			return new ResponseEntity<Void>(HttpStatus.OK); 
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	

}
