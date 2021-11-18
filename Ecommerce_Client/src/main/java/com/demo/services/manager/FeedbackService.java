package com.demo.services.manager;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.BannerInfo;
import com.demo.models.FeedbackInfo;
import com.demo.models.ImageInfo;

@Service("manager/feedbackService")
public class FeedbackService implements IFeedbackService {
	
	private String BASE_URL = "http://localhost:9596/api/manager/feedback/";

	@Override
	public ResponseEntity<Iterable<FeedbackInfo>> findAllInfo() {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.exchange(BASE_URL + "findAll",
					HttpMethod.GET,
					null , 
					new ParameterizedTypeReference<Iterable<FeedbackInfo>>() {} );
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public ResponseEntity<FeedbackInfo> findInfoById(int id) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForEntity(BASE_URL + "findInfoById/" + id, FeedbackInfo.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ResponseEntity<FeedbackInfo> create(FeedbackInfo feedback) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			return restTemplate.postForEntity(BASE_URL + "create", feedback, FeedbackInfo.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<FeedbackInfo>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<Void> update(FeedbackInfo feedback) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.put(BASE_URL + "update/" + feedback.getId(), feedback);
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
}
