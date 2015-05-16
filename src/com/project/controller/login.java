package com.project.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.hibernate.dao.userdao;
import com.hibernate.util.users;

@Controller
@SessionAttributes({"users"})
public class login {
	@Autowired
	private userdao usdao;
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	   public Model user(@ModelAttribute("users")users user) {
		return null;
	   }
	@RequestMapping(value="/userlogin.json", method=RequestMethod.POST)
	public  @ResponseBody String check_login(@ModelAttribute users user, @RequestBody String data) throws ParseException{
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(data);	 
		JSONObject jsonObject = (JSONObject) obj; 
		int cnic = Integer.parseInt((String) jsonObject.get("cnic"));
		String pass = (String) jsonObject.get("pass");
		List<users> list = usdao.getuser(cnic, pass);
		if (list.isEmpty()) 
			return "false";
		else {
			user.setName((String)((users) (list.get(0))).getName());
			System.out.println((String)((users) (list.get(0))).getName());
		}
		return "true";
	}
	@RequestMapping(value="/user.login", method=RequestMethod.POST)
	public String loginuser(@ModelAttribute("users")users user,ModelMap modelm){
		List<users> list = usdao.getuser(user.getCnic(), user.getPassword());
		if (list.isEmpty())
			return "redirect:home.jsp";
		else {
			user.setName(list.get(0).getName());
			return "redirect:home.jsp";
		}
	}
}
