package com.relationdb.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue
	private int tId;
	private String name;
	
	@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
	private List<StudentDetails> student;

	public Teacher() {
		super();
	}

	public Teacher(int tId, String name) {
		super();
		this.tId = tId;
		this.name = name;
	}


	public int gettId() {
		return tId;
	}


	public void settId(int tId) {
		this.tId = tId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public List<StudentDetails> getStudent() {
		return student;
	}


	public void setStudent(List<StudentDetails> student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "Teacher [tId=" + tId + ", name=" + name + ", student=" + student + "]";
	}

	
	
	
	
}
