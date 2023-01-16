package com.CRUD.classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.hibernate.Session;

import com.entity.User;

public class InsertData {

//	Input Classes
	private Scanner sc;
	private BufferedReader br;

//	Variables
	private final int id = 1;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

//	Constructor
	public InsertData() {
		sc = new Scanner(System.in);
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public void oneTimeInsertData() {

//		Call Insert Method User input
		inputMethod();

		Session session = GetSessionFactory.getFactory().getCurrentSession();

		try {

//			Start Session Transaction
			session.beginTransaction();

//			Create Entity Object
			User user = new User(this.id, this.firstName, this.lastName, this.email, this.password);

//			Save User Object
			session.save(user);

//			Session Transaction Commit
			session.getTransaction().commit();

			System.out.println("Insert Completed....");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void multipleInsertData() {

		System.out.print("How Many Records you want to insert : ");
		int record = sc.nextInt();

		for (int i = 0; i < record; i++) {
			
			Session session = GetSessionFactory.getFactory().getCurrentSession();
			
			try {

//			Call input method
				inputMethod();

				User user = new User(id, firstName, lastName, email, password);

				session.beginTransaction();

				session.save(user);

				System.out.println("Insert Completed...");

				session.getTransaction().commit();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
		}

	}

//	Input Method From User
	private void inputMethod() {

		try {

			System.out.print("\nEnter First Name : ");
			this.firstName = br.readLine();

			System.out.print("Enter Last Name : ");
			this.lastName = br.readLine();

			System.out.print("Enter Email : ");
			this.email = br.readLine();

			System.out.print("Enter Password : ");
			this.password = br.readLine();

			System.out.println("\nInsert Done...\n");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
