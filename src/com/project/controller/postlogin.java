package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hibernate.util.users;

@Controller
@SessionAttributes({"users"})
public class postlogin {
	@RequestMapping("/sign-out")
	public String sessiondelete(@ModelAttribute users use, SessionStatus status){
		status.setComplete();
		return "redirect:home.jsp";
	}
}
