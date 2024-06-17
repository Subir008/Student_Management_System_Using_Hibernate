package Dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Dto.Student_database;

public class StudentDao 
{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public void insert(Student_database student)
	{
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		
		System.out.println("Student Data Saved Successfully ........");
	}
	
	public void fetchById(int id) 
	{
		Student_database student = entityManager.find(Student_database.class, id);
		
		System.out.println();
		System.out.println("Student Id : " + student.getStudent_id());
		System.out.println("Student Name : " + student.getStudent_name());
		System.out.println("Student Class : " + student.getStudent_class());
		System.out.println("Student Contact : " + student.getStudent_contact());
		System.out.println("Studewnt Address : " + student.getStudent_address());
		
		System.out.println();
		System.out.println("Student Data Fetch Successfully ........");
		
	}
	
	public void fetchAll()
	{
		Query query = entityManager.createQuery("SELECT x FROM Student_database x " );
		
		List<Student_database> list	= query.getResultList();
		
		for (Student_database student : list)
		{
			System.out.println("------------------------------");
			System.out.println("Student Id : " + student.getStudent_id());
			System.out.println("Student Name : " + student.getStudent_name());
			System.out.println("Student Class : " + student.getStudent_class());
			System.out.println("Student Contact : " + student.getStudent_contact());
			System.out.println("Studewnt Address : " + student.getStudent_address());
			System.out.println("------------------------------");
		}
		
		System.out.println();
		System.out.println("All The Student Data Fetch Successfully ........");
		
	}
	
	public void update(int id)
	{
		Scanner sc = new Scanner(System.in);
		Student_database student = new Student_database();
		
		student = entityManager.find(Student_database.class, id);
		
		if (student != null )
		{
			System.out.println("Enter Student name : ");
			String student_name = sc.next();
			
			System.out.println("Enter Student Class : ");
			int student_class = sc.nextInt();
			
			System.out.println("Enter Student Mobile no. : ");
			long student_contact = sc.nextLong();
			
			System.out.println("Enter Student Address : ");
			String address = sc.next();
			
			student.setStudent_name(student_name);
			student.setStudent_class(student_class);
			student.setStudent_address(address);
			student.setStudent_contact(student_contact);
			
			entityTransaction.begin();
			entityManager.merge(student);
			entityTransaction.commit();
			
			System.out.println("Student Data Updated Successfully ...............");
		
		}else {
			System.out.println("Student Id Not Found !!!!!!!!!!!!");
		}
	}
	
	public void deleteById(int id)
	{
		Student_database student = entityManager.find(Student_database.class, id);
		
		if(student != null)
		{
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			
			System.out.println("Student Data Deleted Successfully");
		}else {
			System.out.println("Student Id Not Found !!!!!!!!!!!!");
		}
	}
	
	public void deleteAll()
	{
		Query query= entityManager.createQuery("DELETE FROM Student_database  ");
	
		entityTransaction.begin();
		query.executeUpdate();
		entityTransaction.commit();
		
		System.out.println("All The Data Has Been Deleted From The Database");
	}
}