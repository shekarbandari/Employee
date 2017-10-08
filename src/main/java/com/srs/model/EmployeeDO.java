package com.srs.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name ="fname")
	private String firstName;

	@Column(name ="mname")
	private String middleName;

	@Column(name ="lname")
	private String lastName;

	@Id
	@Column(name ="empid")
	private String empId;

	@Column(name ="empno")
	private Integer empNo;

	@Column(name ="designation")
	private String designation;

	@Column(name ="location")
	private String location;

	@Column(name ="date")
	private Date doj;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}

