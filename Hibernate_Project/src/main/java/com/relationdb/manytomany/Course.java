package com.relationdb.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private int cId;
	private String course_name;
	
	@ManyToMany(mappedBy = "list", cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_students_id")
	private List<Students> list;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public List<Students> getList() {
		return list;
	}

	public void setList(List<Students> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Course [cId=" + cId + ", course_name=" + course_name + ", list=" + list + "]";
	}
	
	
	
	
}
