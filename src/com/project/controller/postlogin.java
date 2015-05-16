package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hibernate.util.users;

@Controller
@SessionAttributes({"users"})
public class postlogin {
	@RequestMapping("/checking")
	public void test(@ModelAttribute users user){
		System.out.println(user.getName());
	}
}
