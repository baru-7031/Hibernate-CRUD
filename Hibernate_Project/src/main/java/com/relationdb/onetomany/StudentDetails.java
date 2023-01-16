package com.relationdb.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentDetails {

	@Id
	@GeneratedValue
	private int sId;
	private String name;
	private String collegeName;
	
	@ManyToOne
	@JoinColumn(name = "fk_teacher")
	private Teacher teacher;

	public StudentDetails() {
		super();
	}

	public StudentDetails(int sId, String name, String collegeName) {
		super();
		this.sId = sId;
		this.name = name;
		this.collegeName = collegeName;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", name=" + name + ", collegeName=" + collegeName + ", teacher=" + teacher + "]";
	}
	
	
	
}
