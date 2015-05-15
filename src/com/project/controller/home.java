package com.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hibernate.util.hibernate_session;
import com.hibernate.util.mosques;
import com.hibernate.util.prayer_time;
import com.hibernate.util.users;
 
@Controller
public class home {
	Session session;
	@RequestMapping("/home.jsp")
	public ModelAndView helloWorld() {
		session = hibernate_session.getSessionFactory().openSession();
		ModelAndView model = new ModelAndView("home");
		return model;
	}
	@SuppressWarnings("unused")
	@RequestMapping("/mosque_data.json")
	public @ResponseBody String handle_data(HttpServletRequest req){
		String data = (String) req.getParameter("data");
		if (session==null)session = hibernate_session.getSessionFactory().openSession();
		mosques msq = (mosques) session.get(mosques.class, data);
		if (msq==null)
			return "{\"status\" : \"404\"}";
		else {
			prayer_time time = msq.getTimes();
			users admin = msq.getAdmin();
			return "{\"jumma_time\" :\"" + msq.getJumma_time() + "\", \"capacity\" :\""+ msq.getCapacity() + "\", \"eid_time\" : \"" + msq.getEid_time() + "\", \"sect\" : \"" + msq.getSect() + "\"" +",\"status\":\"200\",\"fajar\": \""+time.getFajar()+ "\"" + ",\"zuhr\": \""+time.getZuhr()+ "\"" +",\"asar\": \""+time.getAsar()+ "\"" +",\"maghrib\": \""+time.getMaghrib()+ "\"" +",\"esha\": \""+time.getEsha()+ "\"" +",\"pic\": \""+msq.getPic()+ "\"" + "}";
		}
	}
	@RequestMapping("/modal.load")
	public ModelAndView handle_modal(@RequestBody String data){
		ModelAndView model = new ModelAndView("modal");
		data=data.replace("data=", "");
		mosques msq = (mosques) session.get(mosques.class, new String(data));
		if (msq==null){model.addObject("msqname", "Mosque not Found.");}
		else {
			prayer_time time = msq.getTimes();
			users admin = msq.getAdmin();
			model.addObject("msqname", msq.getPlace_name());model.addObject("msqaddress", "To be Added");model.addObject("msqnumber", admin.getPhone_number());model.addObject("msqsect", msq.getSect());model.addObject("msqadmin", admin.getName());
			model.addObject("Fajar", time.getFajar());model.addObject("Zuhr", time.getZuhr());model.addObject("Asar", time.getAsar());model.addObject("Maghrib", time.getMaghrib());model.addObject("Isha", time.getEsha());model.addObject("Juma", msq.getJumma_time());model.addObject("Eid", msq.getEid_time());
		}
		return model;
	}
	@RequestMapping(value="/user.login", method=RequestMethod.POST)
	public  @ResponseBody String check_login(@ModelAttribute users user, @RequestBody String data) throws ParseException{
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
		}
		return "true";
	}
}