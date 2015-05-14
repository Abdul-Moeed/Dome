package com.project.controller;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate.util.hibernate_session;
import com.hibernate.util.mosques;
import com.hibernate.util.prayer_time;
 
@Controller
public class home {
 
	@RequestMapping("/home.jsp")
	public ModelAndView helloWorld() {
		ModelAndView model = new ModelAndView("home");
		return model;
	}
	@RequestMapping("/mosque_data.json")
	public @ResponseBody String handle_data(@RequestBody String data){
		Session session = hibernate_session.getSessionFactory().openSession();
		session.beginTransaction();
		data=data.substring(0, data.length()-1);
		mosques msq = (mosques) session.get(mosques.class, new String(data));
		if (msq==null)
			return "{\"status\" : \"404\"}";
		else {
			prayer_time time = msq.getTimes();
			return "{\"jumma_time\" :\"" + msq.getJumma_time() + "\", \"capacity\" :\""+ msq.getCapacity() + "\", \"eid_time\" : \"" + msq.getEid_time() + "\", \"sect\" : \"" + msq.getSect() + "\"" +",\"status\":\"200\",\"fajar\": \""+time.getFajar()+ ",\"zuhr\": \""+time.getZuhr()+",\"asar\": \""+time.getAsar()+",\"maghrib\": \""+time.getMaghrib()+",\"esha\": \""+time.getEsha()+",\"pic\": \""+msq.getPic()+ "}";
		}
	}
}