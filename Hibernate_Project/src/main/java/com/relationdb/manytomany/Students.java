package com.relationdb.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Students {

	@Id
	@GeneratedValue
	private int sId;
	private String name;
	private int rollNo;
	
	@ManyToMany(mappedBy = "list", cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_course_id")
	private List<Course> list;
	
	public List<Course> getList() {
		return list;
	}
	public void setList(List<Course> list) {
		this.list = list;
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
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	@Override
	public String toString() {
		return "Students [sId=" + sId + ", name=" + name + ", rollNo=" + rollNo + "]";
	}
	
	
	
}
