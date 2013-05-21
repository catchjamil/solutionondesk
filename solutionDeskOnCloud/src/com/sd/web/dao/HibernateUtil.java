package com.sd.web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sd.web.util.ApplicationContext;

public class HibernateUtil {

	private static SessionFactory sessionFactory = ApplicationContext.getInstance().getHibernateSessionFactory();

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session openSession() {
		return getSessionFactory().openSession();
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}

}
