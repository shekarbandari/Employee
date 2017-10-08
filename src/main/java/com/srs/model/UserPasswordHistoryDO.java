package com.srs.model;



import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the tbluserpasswordhistory database table.
 * 
 */
@Entity
@Table(name = "tbluserpasswordhistory")
@NamedQuery(name = "UserPasswordHistoryDO.findAll", query = "SELECT t FROM UserPasswordHistoryDO t")
public class UserPasswordHistoryDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long userPasswordHistoryId;

	@Column(length = 512)
	private String comments;

	@Column(nullable = false)
	private long createdUserId;

	@Column(nullable = false)
	private Date dateCreated;

	@Column(length = 64)
	private String passwordGUID;

	public String getPasswordGUID() {
		return passwordGUID;
	}

	public void setPasswordGUID(String passwordGUID) {
		this.passwordGUID = passwordGUID;
	}

	@Column(nullable = false, length = 64)
	private String IPAddress;
	

	@Column(nullable = false)
	private Date lastUpdated;

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Column(length = 64)
	private String passwordSALT;

	private Long updatedUserId;

	@Column(nullable = false, length = 256)
	private String userPassword;

	// bi-directional many-to-one association to Tbluser
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	private UserDO tbluser;

	public UserPasswordHistoryDO() {
	}

	public Long getUserPasswordHistoryId() {
		return this.userPasswordHistoryId;
	}

	public void setUserPasswordHistoryId(Long userPasswordHistoryId) {
		this.userPasswordHistoryId = userPasswordHistoryId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	
	public String getIPAddress() {
		return this.IPAddress;
	}

	public void setIPAddress(String IPAddress) {
		this.IPAddress = IPAddress;
	}

	

	public String getPasswordSALT() {
		return this.passwordSALT;
	}

	public void setPasswordSALT(String passwordSALT) {
		this.passwordSALT = passwordSALT;
	}

	public Long getUpdatedUserId() {
		return this.updatedUserId;
	}

	public void setUpdatedUserId(Long updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public UserDO getTbluser() {
		return this.tbluser;
	}

	public void setTbluser(UserDO tbluser) {
		this.tbluser = tbluser;
	}

	public long getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(long createdUserId) {
		this.createdUserId = createdUserId;
	}

}