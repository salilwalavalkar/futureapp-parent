package com.salil.futureapp.dao.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.salil.futureapp.dao.base.IEntityVo;

/**
 * Student Entity Value Object. #HIBERNATE
 * 
 * @author salil
 * @version 1.0
 */
@Entity
@Table(name = "STUDENT")
public class StudentEVO implements IEntityVo {

	private static final long serialVersionUID = 3973292230281068461L;

	@Id
	@SequenceGenerator(name = "pk_sequence", sequenceName = "student_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
	@Column(name = "sid", unique = true, nullable = false)
	private long studId;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "age")
	private int age;

	@Column(name = "createddate")
	private Timestamp dateCreated;

	@Column(name = "modifieddate")
	private Timestamp dateModified;

	public long getStudId() {
		return studId;
	}

	public void setStudId(long studId) {
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

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}

}
