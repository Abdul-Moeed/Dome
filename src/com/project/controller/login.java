package com.project.controller;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate.util.users;

@Controller
public class login {
	private SessionFactory sf;
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	   public Model user(@ModelAttribute("users")users user, Model model) {
		return model;
	   }
	@RequestMapping(value="/userlogin.json", method=RequestMethod.POST)
	public  @ResponseBody String check_login(@ModelAttribute users user, @RequestBody String data) throws ParseException{
		Session session = sf.getCurrentSession();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(data);	 
		JSONObject jsonObject = (JSONObject) obj; 
		int cnic = Integer.parseInt((String) jsonObject.get("cnic"));
		String pass = (String) jsonObject.get("pass");
		Criteria cr = session.createCriteria(users.class);
		cr.add(Restrictions.eq("cnic", cnic));
		cr.add(Restrictions.eq("password", pass));
		if (cr.list().isEmpty()) 
			return "false";
		else {
			user.setName((String)((users) (cr.list().get(0))).getName());
			System.out.println((String)((users) (cr.list().get(0))).getName());
		}
		return "true";
	}
	@RequestMapping(value="/user.login", method=RequestMethod.POST)
	public ModelAndView loginuser(@ModelAttribute("users")users user,BindingResult result,ModelMap modelm){
		ModelAndView model = new ModelAndView("home");
		return model;
	}
}
