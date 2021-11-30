package com.demo.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.models.BannerInfo;
import com.demo.models.CategoryInfo;

@Component("categoryValidator")
public class CategoryValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		boolean result = clazz.equals(CategoryInfo.class);
		return result;
	}

	@Override
	public void validate(Object target, Errors errors) {
	}

}
