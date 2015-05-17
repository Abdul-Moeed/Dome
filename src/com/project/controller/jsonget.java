package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.hibernate.dao.mosquedao;
import com.hibernate.dao.userdao;
import com.hibernate.util.mosques;
import com.hibernate.util.prayer_time;
import com.hibernate.util.users;

@Controller
@SessionAttributes({"users"})
public class jsonget {
	@Autowired
	private userdao usdao;
    @Autowired
    private mosquedao msqdao;
	@ModelAttribute("users")
	public users getuser(){
		return new users();
	}
	@RequestMapping(value="/userlogin.json", method=RequestMethod.POST)
	public  @ResponseBody String check_login(@ModelAttribute users user, @RequestBody String data) throws ParseException{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(data);	 
		JSONObject jsonObject = (JSONObject) obj; 
		int cnic = Integer.parseInt((String) jsonObject.get("cnic"));
		String pass = (String) jsonObject.get("pass");
		List<users> list = usdao.getuser(cnic);
		if (list.isEmpty()) 
			return "{\"status\": \"false\"}";
		else {
			if(passwordEncoder.matches(pass, list.get(0).getPassword())){
				user.setName(list.get(0).getName());
				return "{\"status\": \"true\"}";}
			else
				return "{\"status\": \"false\"}";
		}
	}
	@RequestMapping("/mosque_data.json")
	public @ResponseBody String handle_data(HttpServletRequest req){
		String data = (String) req.getParameter("data");
        mosques msq = msqdao.getmsq(data);
		if (msq==null)
			return "{\"status\" : \"404\"}";
		else {
			prayer_time time = msq.getTimes();
			return "{\"jumma_time\" :\"" + msq.getJumma_time() + "\", \"capacity\" :\""+ msq.getCapacity() + "\", \"eid_time\" : \"" + msq.getEid_time() + "\", \"sect\" : \"" + msq.getSect() + "\"" +",\"status\":\"200\",\"fajar\": \""+time.getFajar()+ "\"" + ",\"zuhr\": \""+time.getZuhr()+ "\"" +",\"asar\": \""+time.getAsar()+ "\"" +",\"maghrib\": \""+time.getMaghrib()+ "\"" +",\"esha\": \""+time.getEsha()+ "\"" +",\"pic\": \""+msq.getPic()+ "\"" + "}";
		}
	}
	@RequestMapping(value="/signup.json" , method=RequestMethod.POST)
	public @ResponseBody String handle_signup(@ModelAttribute users user, @RequestBody String data) throws ParseException{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(data);	 
		JSONObject jsonObject = (JSONObject) obj; 
		int cnic = Integer.parseInt((String) jsonObject.get("cnic"));
		String pass = (String) jsonObject.get("pass");
		String phone_number = (String) jsonObject.get("phone_number");
		String email = (String) jsonObject.get("email");
		String name = (String) jsonObject.get("name");
		if (!usdao.getuser(cnic).isEmpty())
			return "{\"status\" : \"cnic already present\"}";
		if (!usdao.getuser(email).isEmpty())
			return "{\"status\" : \"email already present\"}";
		if (!usdao.getusernum(phone_number).isEmpty())
			return "{\"status\" : \"phone number already present\"}";
		users user_presistent = new users();
		user_presistent.setCnic(cnic);user_presistent.setName(name);user_presistent.setEmail(email);user_presistent.setPassword(passwordEncoder.encode(pass));user_presistent.setPhone_number(phone_number);user_presistent.setRole("ROLE_USER");user_presistent.setStatus("user");
		usdao.save(user_presistent);
		return "{\"status\" : \"Registered.Welcome\"}";
	}
}
