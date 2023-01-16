package com.CRUD.classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.hibernate.Session;

import com.entity.User;

public class UpdateData {

//	Variables
	private final int id = 1;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	private BufferedReader br;
	private Scanner sc;

	public UpdateData() {
		sc = new Scanner(System.in);
		br = new BufferedReader(new InputStreamReader(System.in));
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

	public void updateOnlyOne() {

		System.out.print("\nEnter id for Update : ");
		int id = sc.nextInt();
		Session session = GetSessionFactory.getFactory().getCurrentSession();

		session.beginTransaction();
		try {

			User user = session.get(User.class, id);

			if (user == null) {
				throw new NullPointerException("** ID Not Found **");
			}

			System.out.println("\nfirstname, lastname, email, password | This are the fields");
			System.out.print("How Many Field's You Want to Update : ");
			int n = sc.nextInt();

			if (n <= 4 && n > 0) {

				try {
//				Transaction Start

					for (int i = 0; i < n; i++) {
						System.out.print("Enter Your Choice : ");
						String str = br.readLine();

//					Setters
						switch (str) {
						case "firstname":
							System.out.println("Enter First Name value : ");
							String firstName = br.readLine();
							user.setFirstName(firstName);
							break;
						case "lastname":
							System.out.println("Enter Last Name value : ");
							String lastName = br.readLine();
							user.setLastName(lastName);
							break;
						case "email":
							System.out.println("Enter email value : ");
							String emial = br.readLine();
							user.setEmail(emial);
							break;
						case "password":
							System.out.println("Enter password value : ");
							String password = br.readLine();
							user.setPassword(password);
							break;
						default:
							System.out.println("Wrong Choice");
						}

					}

//				Transaction Close
					session.getTransaction().commit();

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
//				Session close
					session.close();
				}
			} else {
				System.out.println("\nOnly 4 Fields are there... ** Try again **\n");
			}
		} catch (Exception e) {
			System.out.println("\nSorry Id is not Present in data base ** Please Try again **\n");
			e.printStackTrace();
			session.close();
		}

	}

	public void updateAllFields() {

		System.out.println("Enter id which you want to update : ");
		int id = sc.nextInt();

		Session session = GetSessionFactory.getFactory().getCurrentSession();

		try {

			session.beginTransaction();

			User user = session.get(User.class, id);

			if (user != null) {

				inputMethod();

				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setPassword(password);

				session.getTransaction().commit();

				System.out.println("Update Completed...");

			} else {
				System.out.println("Wrong id " + id + " please try again");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//			Session Close
			session.close();
		}

	}

}
