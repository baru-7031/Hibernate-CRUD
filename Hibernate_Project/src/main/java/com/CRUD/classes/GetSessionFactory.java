package com.CRUD.classes;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetSessionFactory {

	public static SessionFactory getFactory() {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		System.out.println("Session Factory Object Created...");
		
		return factory;
		
	}
	
}
