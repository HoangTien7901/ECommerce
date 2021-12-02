package com.demo.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.models.UserInfo;
import com.demo.services.user.UserService;

@Component("userValidator")
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		boolean result = clazz.equals(UserInfo.class);
		return result;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserInfo object = (UserInfo) target;
		if (!(object.getUsername() == null || object.getUsername().isEmpty())) {
			ResponseEntity<UserInfo> responseEntity = userService.findInfoByUsername(object.getUsername());
			if (!(responseEntity == null || responseEntity.getStatusCode() != HttpStatus.OK)) {
				UserInfo user = responseEntity.getBody();
				if (user != null) {
					errors.rejectValue("username", "account.username.exists");
				}
			}
		}
	}
}
