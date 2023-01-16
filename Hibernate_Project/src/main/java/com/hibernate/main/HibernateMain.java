package com.hibernate.main;

import java.util.Scanner;

import com.CRUD.classes.DeleteData;
import com.CRUD.classes.InsertData;
import com.CRUD.classes.ReadData;
import com.CRUD.classes.UpdateData;

public class HibernateMain {

	public static void main(String[] args) {
		
		boolean loop = false;
		
		Scanner sc = new Scanner(System.in);
		InsertData insert = new InsertData();
		ReadData read = new ReadData();
		UpdateData update = new UpdateData();
		DeleteData delete = new DeleteData();
		
		while(!loop) {
			
			System.out.println("Enter 1 for insert 1 time : ");
			System.out.println("Enter 2 for multiple insert values : ");
			System.out.println("Enter 3 for Read All data : ");
			System.out.println("Enter 4 for Read data by id : ");
			System.out.println("Enter 5 for Record Size : ");
			System.out.println("Enter 6 for Update all fields : ");
			System.out.println("Enter 7 for Update fields in your choice : ");
			System.out.println("Enter 8 for delete by id : ");
			System.out.println("Enter 9 for delete All : ");					 		
			System.out.println("Enter 10 for 'exit' : ");
			System.out.println("Enter your choice : ");
			int n = sc.nextInt();
			
			switch(n) {
			case 1:
				insert.oneTimeInsertData();
				break;
			case 2:
				insert.multipleInsertData();
				break;
			case 3:
				read.readAllData();
				break;
			case 4:
				read.readDataUsingId();
				break;
			case 5:
				read.dataSize();
				break;
			case 6:
				update.updateAllFields();
				break;
			case 7:
				update.updateOnlyOne();
				break;
			case 8:
				delete.deleteById();
				break;
			case 9:
				delete.deleteAll();
				break;
			case 10:
				System.out.println("Thank You for Using created by **Subham Kr Gupta**");
				loop = true;
				break;
			default:
				System.out.println("\nSorry Wrong Choice\n");
			}
			
		}
		
		
	}
	
}







