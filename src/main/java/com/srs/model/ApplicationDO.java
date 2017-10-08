package com.srs.model;

/**
 * @author SHEKAR BANDARI
 *
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tblapplication")
@NamedQuery(name="ApplicationDO.findAll", query="SELECT t FROM ApplicationDO t")
public class ApplicationDO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private long applicationId;

	@Column(name ="applicationName")
	private String applicationName;

	@Column(name ="applicationDetails")
	private String applicationDetails;
	
	@Column(name ="skillSet")
	private String skillSet;
	
	
	@Column(name ="designation")
	private String designation;
	@Column(name ="location")
	private String location;
	
	
	
	
	

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

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	@Column(name ="roleId")
	private Integer roleId;

	@Column(name ="userId")
	private long userId;

	

	public String getApplicationName() {
		return applicationName;
	}

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationDetails() {
		return applicationDetails;
	}

	public void setApplicationDetails(String applicationDetails) {
		this.applicationDetails = applicationDetails;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	
	

	
}

