package com.sd.web.util;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ApplicationContextListener implements ServletContextListener {

	ApplicationContext applicationContext = ApplicationContext.getInstance();

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(" Application closed...");

	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(" Application Starting...");
		try {
			ServletContext servletContext = sce.getServletContext();
			applicationContext.setServletContext(servletContext);
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
			applicationContext.setHibernateSessionFactory((SessionFactory) wac.getBean("sessionFactory"));

			Properties configProp = new Properties();
			configProp.load(ApplicationContextListener.class.getClassLoader().getResourceAsStream("config.properties"));
			applicationContext.setConfigProp(configProp);

			System.out.println(" Application Started...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
