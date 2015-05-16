package com.hibernate.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.util.users;
@Repository
public class userdaoimpl implements userdao{
	private SessionFactory sf;
	public userdaoimpl(SessionFactory sf){
		this.setSf(sf);
	}
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<users> getuser(int key, String pass) {
		Session sess = sf.getCurrentSession();
		Criteria cr = sess.createCriteria(users.class);
		cr.add(Restrictions.eq("cnic", key));
		cr.add(Restrictions.eq("password", pass));
		return cr.list();
	}
}
