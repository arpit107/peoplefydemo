package com.peoplefy.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory factory;
	public HibernateUtil() {
		// TODO Auto-generated constructor stub
	}
	public static synchronized SessionFactory getSessionFactory()
	{
		if(factory==null)
		{
			factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}
}
