package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.hibernate.dao.userdao;
import com.hibernate.util.users;

@Controller
public class signup {
    @Autowired
    @Qualifier("uservalidator")
    private Validator validator;
    @Autowired
    private userdao usdao;
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(value="/values", method=RequestMethod.POST)
	public String user_signup(@ModelAttribute("users")@Validated users user,BindingResult res,SessionStatus status){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (res.hasErrors()) {
            return "signup";
        }
		String pass = passwordEncoder.encode( user.getPassword());
		user.setPassword(pass);
		usdao.save(user);
		status.setComplete();
		return "values";
	}
}
