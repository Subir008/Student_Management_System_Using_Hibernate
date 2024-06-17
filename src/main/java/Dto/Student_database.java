package Dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student_database
{
	@Id
	int student_id ;
	
	@Column(nullable = false)
	String student_name ;
	
	@Column(nullable = false, unique = true)
	long student_contact;
	
	@Column(nullable = false)
	int student_class;
	
	@Column
	String student_address;

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public long getStudent_contact() {
		return student_contact;
	}

	public void setStudent_contact(long student_contact) {
		this.student_contact = student_contact;
	}

	public int getStudent_class() {
		return student_class;
	}

	public void setStudent_class(int student_class) {
		this.student_class = student_class;
	}
	
	
}
