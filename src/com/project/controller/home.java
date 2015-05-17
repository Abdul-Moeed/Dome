package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hibernate.dao.mosquedao;
import com.hibernate.util.mosques;
import com.hibernate.util.prayer_time;
import com.hibernate.util.users;
 
@Controller
@SessionAttributes({"users"})
public class home {
    @Autowired
    private mosquedao msqdao;
	@ModelAttribute("users")
	public users getuser(){
		return new users();
	}
	@RequestMapping(value="/home.jsp")
	public ModelAndView helloWorld() {
		ModelAndView model = new ModelAndView("home");
		return model;
	}
	@RequestMapping("/modal.load")
	public ModelAndView handle_modal(@RequestBody String data){
		ModelAndView model = new ModelAndView("modal");
		data=data.replace("data=", "");
        mosques msq = msqdao.getmsq(data);
		if (msq==null){model.addObject("msqname", "Mosque not Found.");}
		else {
			prayer_time time = msq.getTimes();
			users admin = msq.getAdmin();
			model.addObject("msqname", msq.getPlace_name());model.addObject("msqsect", msq.getSect());
			model.addObject("msqaddress", "To be Added");model.addObject("msqnumber", admin.getPhone_number());model.addObject("msqadmin", admin.getName());
			model.addObject("Fajar", time.getFajar());model.addObject("Zuhr", time.getZuhr());model.addObject("Asar", time.getAsar());model.addObject("Maghrib", time.getMaghrib());model.addObject("Isha", time.getEsha());model.addObject("Juma", msq.getJumma_time());model.addObject("Eid", msq.getEid_time());
		}
		return model;
	}
	@RequestMapping("/userup")
	public String handle_signup(){
		return "signup";
	}
}