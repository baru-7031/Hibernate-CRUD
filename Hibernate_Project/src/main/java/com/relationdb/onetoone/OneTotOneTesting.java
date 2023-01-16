package com.relationdb.onetoone;

import org.hibernate.Session;

import com.CRUD.classes.GetSessionFactory;

public class OneTotOneTesting {
	
	public static void main(String[] args) {
		
		Customer customer = new Customer(1, "SUbham", "subham@gamil.com", "1234567789");
	
		Wallet wallet = new Wallet(12, 20000, customer);
		
		Session session = GetSessionFactory.getFactory().getCurrentSession();
		
		session.beginTransaction();
		
		session.save(customer);
		session.save(wallet);
		
		session.getTransaction().commit();
		
		System.out.println("Done...");
		
		
	}

}
