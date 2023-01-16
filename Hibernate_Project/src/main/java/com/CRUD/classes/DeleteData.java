package com.CRUD.classes;

import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;

import com.entity.User;


public class DeleteData {
	
	public void deleteAll() {
		
		String query = "delete from User";
		Session session = GetSessionFactory.getFactory().getCurrentSession();
		
		try {
			
//			Transaction Start
			session.beginTransaction();
			
//			Query Created
			Query q1 = session.createQuery(query);
			
//			Query Execute
			q1.executeUpdate();
			
//			Transaction close
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
	
	public void deleteById() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter id for delete record : ");
		int id = sc.nextInt();
		
		Session session = GetSessionFactory.getFactory().getCurrentSession();
		
		try {
			
//			Session Start
			session.beginTransaction();
			
//			Get the User
			User user = session.get(User.class, id);
			
			if(user != null) {
//				Delete Method
				session.delete(user);
				
				System.out.println("Delete Completed...");
			}
			else {
				System.out.println("Wrong Id : " + id + " please try again");
			}
			
//			
			session.getTransaction().commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
//			Session close
			session.close();
		}
		
	}

}
