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
	public List<users> getuser(int key) {
		Session sess = sf.getCurrentSession();
		Criteria cr = sess.createCriteria(users.class);
		cr.add(Restrictions.eq("cnic", key));
		return cr.list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<users> getuser(String email) {
		Session sess = sf.getCurrentSession();
		Criteria cr = sess.createCriteria(users.class);
		cr.add(Restrictions.eq("email", email));
		return cr.list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<users> getusernum(String phone_number) {
		Session sess = sf.getCurrentSession();
		Criteria cr = sess.createCriteria(users.class);
		cr.add(Restrictions.eq("phone_number", phone_number));
		return cr.list();
	}
	@Transactional
	public void save(users user) {
		Session sess = sf.getCurrentSession();
		sess.save(user);
	}
}
