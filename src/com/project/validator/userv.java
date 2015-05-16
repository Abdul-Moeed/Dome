package com.project.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hibernate.dao.userdao;
import com.hibernate.util.users;
@Component
public class userv implements Validator {
	@Autowired
	private userdao usdao;
	@Override
	public boolean supports(Class<?> classz) {
		return users.class.equals(classz);
	}

	@Override
	public void validate(Object user, Errors errors) {
		users user_validated = (users) user;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cnic",
				"required.cn", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"required.name", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Field name is required.");
		if (!usdao.getuser(user_validated.getCnic()).isEmpty())
			errors.rejectValue("cnic", "required.cnic");
		if (!usdao.getuser(user_validated.getEmail()).isEmpty())
			errors.rejectValue("email", "required.email");
		if (!usdao.getusernum(user_validated.getPhone_number()).isEmpty())
			errors.rejectValue("phone_number", "required.phone_number");
		
	}

}
