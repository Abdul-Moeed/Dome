package com.project.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hibernate.dao.userdao;
import com.hibernate.util.users;
@Component
public class userlog implements Validator{
	@Autowired
	private userdao usdao;
	@Override
	public boolean supports(Class<?> classz) {
		return users.class.equals(classz);
	}
	@Override
	public void validate(Object arg0, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cnic",
				"required.cn", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Field name is required.");
	}
}
