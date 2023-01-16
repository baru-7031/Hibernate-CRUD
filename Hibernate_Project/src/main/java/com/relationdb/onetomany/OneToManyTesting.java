package com.relationdb.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.CRUD.classes.GetSessionFactory;

public class OneToManyTesting {

	public static void main(String[] args) {
		
		List<StudentDetails> list = new ArrayList<>();
		
		list.add(new StudentDetails(1, "abc", "abc"));
		list.add(new StudentDetails(2, "subham", "abc"));
		list.add(new StudentDetails(3, "gupta", "abc"));
		list.add(new StudentDetails(4, "ashish", "abc"));
		
		Teacher teacher = new Teacher(12, "SUbham");
		
		Session session = GetSessionFactory.getFactory().getCurrentSession();
		
		session.beginTransaction();
		
		session.save(teacher);
		
		for(StudentDetails s : list) {
			s.setTeacher(teacher);
		}
		for(StudentDetails s : list) {
			session.save(s);
		}

		
		session.getTransaction().commit();
		
		session.close();
		
		System.out.println("Done...");
		
		
	}
	
}










