package Controller;

import java.util.Scanner;

import Dao.StudentDao;
import Dto.Student_database;

public class StudentController 
{
	public static void main(String[] args) 
	{
		System.out.println(" ****** STUDENT MANAGEMENT SYSTEM ******* ");
		
		Scanner sc = new Scanner(System.in);
		Student_database student = new Student_database();
		StudentDao studentdao = new StudentDao();
		
		int condition = 9;
		while (condition == 9)
		{
		
		System.out.println("----------Choose Your Option---------"); 
		System.out.println();
		System.out.println("1. Insert New Student Details");
		System.out.println("2. Update Student Details");
		System.out.println("3. Fetch Student Details by Id");
		System.out.println("4. Fetch All the Student Details");
		System.out.println("5. Delete Student Details by Id");
		System.out.println("6. Delete All Student Details");
		System.out.println();

		int key = sc.nextInt();
		
		switch (key) {
		case 1:
			int num = 0 ;
			while(num == 0)
			{
				System.out.println("Enter Student ID : ");
				int id = sc.nextInt();
				
				System.out.println("Enter Student Name : ");
				String name = sc.next();

				System.out.println("Enter Student Class : ");
				int student_class = sc.nextInt();
				
				System.out.println("Enter Student Contact No. : ");
				long contact = sc.nextLong();
				
				System.out.println("Enter Student Address : ");
				String address = sc.next();
				
				student.setStudent_id(id);
				student.setStudent_name(name);
				student.setStudent_class(student_class);
				student.setStudent_contact(contact);
				student.setStudent_address(address);
				
				studentdao.insert(student);
				
				System.out.println();
				System.out.println("Do You Want To Add More Student Details Press 0 or Press 1 to Exit");
				num = sc.nextInt();
				
				if(num == 1)
				{
					System.out.println("Thank You");
					System.out.println();
				}
			}
			System.out.println();
			System.out.println("Do You Want To Do Any Further Operation Press 9 or Press 8 for Exit");
			condition = sc.nextInt();
			
			if(condition == 8)
			{
				System.out.println("------------- Operation Completed -----------------");
			}
			System.out.println();
			
			break;
			
		case 2:
			System.out.println();
			System.out.println("Enter Student ID To Be Updated : ");
			int update = sc.nextInt();
			
			studentdao.update(update);
			
			System.out.println();
			System.out.println("Do You Want To Do Any Further Operation Press 9 or Press 8 for Exit");
			condition = sc.nextInt();
			
			if(condition == 8)
			{
				System.out.println("------------- Operation Completed -----------------");
			}
			System.out.println();
			
			break;
			
		case 3:
			System.out.println();
			System.out.println("Enter Student ID : ");
			int fetch = sc.nextInt();
			
			studentdao.fetchById(fetch);
			
			System.out.println();
			System.out.println("Do You Want To Do Any Further Operation Press 9 or Press 8 for Exit");
			condition = sc.nextInt();
			
			if(condition == 8)
			{
				System.out.println("------------- Operation Completed -----------------");
			}
			System.out.println();
			break;
			
		case 4:
			studentdao.fetchAll();
			
			System.out.println();
			System.out.println("Do You Want To Do Any Further Operation Press 9 or Press 8 for Exit");
			condition = sc.nextInt();
			
			if(condition == 8)
			{
				System.out.println("------------- Operation Completed -----------------");
			}
			System.out.println();
			
			break;
			
		case 5:
			System.out.println();
			System.out.println("Enter Student ID : ");
			int delete = sc.nextInt();
			
			studentdao.deleteById(delete);
			
			System.out.println();
			System.out.println("Do You Want To Do Any Further Operation Press 9 or Press 8 for Exit");
			condition = sc.nextInt();
			
			if(condition == 8)
			{
				System.out.println("------------- Operation Completed -----------------");
			}
			System.out.println();
			
			break;
			
		case 6:
			System.out.println();
			System.out.println("Do You Really Want To Delete All The Data Press 'Y' OR Press 'N' To Exit");
			String ch = sc.next();
			
			String ch_check = ch.toUpperCase();
			
			String Y = "Y";
			String N = "N";
			
			if (ch_check.equals(Y) )
			{
				studentdao.deleteAll();
			}else if (ch_check.equals(N))
			{
				System.out.println("Data Remain Same ");
			}
			System.out.println();
			System.out.println("Do You Want To Do Any Further Operation Press 9 or Press 8 for Exit");
			condition = sc.nextInt();
			
			if(condition == 8)
			{
				System.out.println("------------- Operation Completed -----------------");
			}
			System.out.println();
			break;

		default:
			System.out.println("Invalid Option");
			System.out.println();
			break;
		}
		
		}
	}
}