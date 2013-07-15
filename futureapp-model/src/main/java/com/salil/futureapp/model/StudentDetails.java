package com.salil.futureapp.model;

import java.util.Date;

import com.salil.futureapp.model.base.IModel;

/**
 * Student Model.
 * 
 * @author salil
 * @version 1.0
 */
public class StudentDetails implements IModel {

	private static final long serialVersionUID = -7194224380508410520L;

	private String studId;

	private String firstName;

	private String lastName;

	private int age;
	
	private Date dateCreated;

	private Date dateModified;
	

	public String getStudId() {
		return studId;
	}

	public void setStudId(String studId) {
		this.studId = studId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

}
