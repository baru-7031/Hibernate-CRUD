package com.CRUD.classes;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.entity.User;

public class ReadData {
	
	public void readAllData() {
		
		Session session = GetSessionFactory.getFactory().getCurrentSession();
		
		try {
			
//			Transaction start
			session.beginTransaction();
			
//			Get All Records 
			List<User> list = session.createQuery("from User").getResultList();
			
//			Print User Data's
			list.forEach((user) -> {
				
				System.out.print("\nId : " + user.getId());
				System.out.print(" | First Name : " + user.getFirstName());
				System.out.print(" | Last Name : " + user.getLastName());
				System.out.print(" | Email : " + user.getEmail());
				System.out.print(" | Password : " + user.getPassword()+"\n");
				
			});
			
			
//			Transaction Commit
			session.getTransaction().commit();
			
			System.out.println("\nRead Completed...\n\n");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
//			Session Close
			session.close();
		}
		
	}
	
	public void dataSize() {
		Session session = GetSessionFactory.getFactory().getCurrentSession();
		
		try {
			
//			Transaction Start
			session.beginTransaction();
			
//			Collect Total Record's
			List<User> list = session.createQuery("from User").getResultList();
			
//			Size Print
			System.out.println("\n Total Record's are " + list.size());
			
//			Transaction Close
			session.getTransaction().commit();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
//			Session Close
			session.close();
		}
		
	}
	
	public void readDataUsingId() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter id : ");
		int id = sc.nextInt();
		
		Session session = GetSessionFactory.getFactory().getCurrentSession();
		
		try {
			
//			Transaction Start
			session.beginTransaction();
			
//			Check id is present or not
			User user = session.get(User.class, id);
			
//			Check User if id is wrong it return null
			if(user != null) {
				System.out.print("\nId : " + user.getId());
				System.out.print(" | First Name : " + user.getFirstName());
				System.out.print(" | Last Name : " + user.getLastName());
				System.out.print(" | Email : " + user.getEmail());
				System.out.print(" | Password : " + user.getPassword()+"\n");
				
				
				System.out.println("\nRead user " + id + " completed...\n\n");
			}
			else {
				System.out.println("Wrong id : " + id + " please try again");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
//			Session Close
			session.close();
		}
		
		
	}

}







