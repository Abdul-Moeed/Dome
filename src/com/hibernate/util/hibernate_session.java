package com.hibernate.util;

import org.hibernate.SessionFactory;

public class hibernate_session {
	private SessionFactory sessionFactory;
	 
	public hibernate_session(SessionFactory session){
		this.setSessionFactory(session);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
