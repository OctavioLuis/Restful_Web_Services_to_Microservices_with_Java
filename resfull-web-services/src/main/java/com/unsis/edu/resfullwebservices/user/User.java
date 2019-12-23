package com.unsis.edu.resfullwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	private Integer id;
	
	@Size(min = 2, message = "Name should have atleast 2 characters")
	private String name;
	
	@Past
	private Date birhDate;
	
	
	protected  User() {
	
}
	public User(Integer id, String name, Date birhDate) {
		super();
		this.id = id;
		this.name = name;
		this.birhDate = birhDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirhDate() {
		return birhDate;
	}

	public void setBirhDate(Date birhDate) {
		this.birhDate = birhDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birhDate=" + birhDate + "]";
	}
	
	

}
