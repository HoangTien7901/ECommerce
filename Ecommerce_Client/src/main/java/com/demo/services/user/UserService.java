package com.demo.services.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.models.UserInfo;

@Service("userService")
public class UserService implements IUserService {

	private String BASE_URL = "http://localhost:9596/api/user/";

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
	public ResponseEntity<UserInfo> findInfoByUsername(String username) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			return restTemplate.getForEntity(BASE_URL + "findInfoByUsername/" + username, UserInfo.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<UserInfo> response = restTemplate.getForEntity(BASE_URL + "findInfoByUsername/" + username, UserInfo.class);
			if (!(response == null || response.getStatusCode() != HttpStatus.OK)) {
				List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
				UserInfo user = response.getBody();
				
				if (user.getRoleId() == 1) {
					roles.add(new SimpleGrantedAuthority("ROLE_USER"));
				} else {
					roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
				}
				
				return new User(user.getUsername(), user.getPassword(), roles);
			} else {
				throw new Exception("Server - Find user by username error " + (response == null ? "null" : response.getStatusCode()));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
