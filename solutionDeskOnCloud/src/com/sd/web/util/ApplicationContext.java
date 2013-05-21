package com.sd.web.util;

import java.util.Properties;

import javax.servlet.ServletContext;

import org.hibernate.SessionFactory;

public class ApplicationContext {

	private static ApplicationContext instance = new ApplicationContext();

	public static ApplicationContext getInstance() {
		return instance;
	}

	private Properties configProp;

	private ServletContext servletContext;

	private SessionFactory hibernateSessionFactory;

	public Properties getConfigProp() {
		return configProp;
	}

	public SessionFactory getHibernateSessionFactory() {
		return hibernateSessionFactory;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setConfigProp(Properties configProp) {
		this.configProp = configProp;
	}

	public void setHibernateSessionFactory(SessionFactory hibernateSessionFactory) {
		this.hibernateSessionFactory = hibernateSessionFactory;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
