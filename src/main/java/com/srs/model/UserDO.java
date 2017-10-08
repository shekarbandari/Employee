package com.srs.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author SHEKAR BANDARI
 *
 */

@Entity
@Table(name="tbluser")
@NamedQuery(name="UserDO.findAll", query="SELECT t FROM UserDO t")
public class UserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private long userId;
	private String userName;
	private String userPassword;
	
	private byte roleId;
	private byte imagePassword;
	
	private long createdUserId;
	private Long updatedUserId;
	private Date lastUpdated;
	private Date lastPasswordChanged;
	private int totalPasswordChangeWarnings;
	private String userEmail;
	
	
	
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getTotalPasswordChangeWarnings() {
		return totalPasswordChangeWarnings;
	}
	public void setTotalPasswordChangeWarnings(int totalPasswordChangeWarnings) {
		this.totalPasswordChangeWarnings = totalPasswordChangeWarnings;
	}
	public Date getLastPasswordChanged() {
		return lastPasswordChanged;
	}
	public void setLastPasswordChanged(Date lastPasswordChanged) {
		this.lastPasswordChanged = lastPasswordChanged;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public Long getUpdatedUserId() {
		return updatedUserId;
	}
	public void setUpdatedUserId(Long updatedUserId) {
		this.updatedUserId = updatedUserId;
	}
	public long getCreatedUserId() {
		return createdUserId;
	}
	public void setCreatedUserId(long createdUserId) {
		this.createdUserId = createdUserId;
	}
	private String passwordSALT;
	private String passwordGUID;
	
	@Column(nullable = false)
	private Date dateCreated;
	
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getPasswordSALT() {
		return passwordSALT;
	}
	public void setPasswordSALT(String passwordSALT) {
		this.passwordSALT = passwordSALT;
	}
	public String getPasswordGUID() {
		return passwordGUID;
	}
	public void setPasswordGUID(String passwordGUID) {
		this.passwordGUID = passwordGUID;
	}
	public byte getImagePassword() {
		return imagePassword;
	}
	public void setImagePassword(byte imagePassword) {
		this.imagePassword = imagePassword;
	}
	public byte getRoleId() {
		return roleId;
	}
	public void setRoleId(byte roleId) {
		this.roleId = roleId;
	}
	
}
