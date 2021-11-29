package com.demo.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.models.ProductInfo;

@Component("productValidator")
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ProductInfo.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// viet them custom validation
		ProductInfo product = (ProductInfo) target;
		if(product.getName().equalsIgnoreCase("abc")) {
			errors.rejectValue("username", "account.username.exists");
		}
		
	}
}
