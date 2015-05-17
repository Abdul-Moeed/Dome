package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hibernate.dao.userdao;
import com.hibernate.util.users;

@Controller
@SessionAttributes({"users"})
public class login {
	@Autowired
	private userdao usdao;
	@Autowired
	@Qualifier("userloginvalidator")
	private Validator validator;
	    
	@InitBinder
	private void initBinder(WebDataBinder binder) {
	     binder.setValidator(validator);
	}
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	   public Model user(@ModelAttribute("users")users user) {
		return null;
	   }
	@RequestMapping(value="/user.login", method=RequestMethod.POST)
	public String loginuser(@ModelAttribute("users")@Validated users user,BindingResult res,ModelMap modelm){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		List<users> list = usdao.getuser(user.getCnic());
		if (res.hasErrors()){
			System.out.println("innn");
			return "redirect:home.jsp";
		}
		if (list.isEmpty())
			return "redirect:home.jsp";
		else {
			if(passwordEncoder.matches(user.getPassword(), list.get(0).getPassword())){
				user.setName(list.get(0).getName());
				return "redirect:home.jsp";}
			else
				return "redirect:home.jsp";
		}
	}
}
