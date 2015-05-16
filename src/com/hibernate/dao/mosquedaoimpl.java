package com.hibernate.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.util.mosques;
@Repository
public class mosquedaoimpl implements mosquedao{
	private SessionFactory sf;
	public mosquedaoimpl(SessionFactory sf){
		this.setSf(sf);
	}
	public SessionFactory getSf() {
		return sf;
	}
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	@Transactional
	public mosques getmsq(String key) {
		Session sess = sf.getCurrentSession();
		mosques msq = (mosques) sess.get(mosques.class, key);
		Hibernate.initialize(msq.admin);
		return msq;
	}
}
