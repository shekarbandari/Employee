package com.srs.model;

import java.io.Serializable;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tbluserrole database table.
 * 
 */
@Entity
@Table(name="tbluserrole")
@NamedQuery(name="UserRoleDO.findAll", query="SELECT t FROM UserRoleDO t")
public class UserRoleDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int userRoleId;

	@Column(length=512)
	private String comments;

	@Column(nullable=false)
	private long createdUserId;

	@Column(nullable=false)
	private Date dateCreated;

	@Column(length=64)
	private String IPAddress;

/*	@Column(nullable=false)
	private byte isDisplayOnWeb;*/

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdated;

/*	@Column(nullable=false)
	private long sortOrder;

	@Column(length=128)
	private String tag;*/
	
	@Column(nullable=false)
	private int pendingCount;
	
	@Column(nullable=false)
	private int totalCount;


	private long updatedUserId;
	
	@Column(nullable=false)
	private byte isPublished;
	
	private long publishedUserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datePublished;

	

	

	//bi-directional many-to-one association to Tblrole
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RoleId", nullable=false)
	private RoleDO tblrole;

	

	//bi-directional many-to-one association to Tbluser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="UserId", nullable=false)
	private UserDO tbluser;

	public UserRoleDO() {
	}

	public int getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public long getCreatedUserId() {
		return this.createdUserId;
	}

	public void setCreatedUserId(long createdUserId) {
		this.createdUserId = createdUserId;
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

	/*public byte getIsDisplayOnWeb() {
		return this.isDisplayOnWeb;
	}

	public void setIsDisplayOnWeb(byte isDisplayOnWeb) {
		this.isDisplayOnWeb = isDisplayOnWeb;
	}*/

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/*public long getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(long sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}*/

	public long getUpdatedUserId() {
		return this.updatedUserId;
	}

	public void setUpdatedUserId(long updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	

	public RoleDO getTblrole() {
		return this.tblrole;
	}

	public void setTblrole(RoleDO tblrole) {
		this.tblrole = tblrole;
	}

	

	public UserDO getTbluser() {
		return this.tbluser;
	}

	public void setTbluser(UserDO tbluser) {
		this.tbluser = tbluser;
	}

	public int getPendingCount() {
		return this.pendingCount;
	}

	public void setPendingCount(int pendingCount) {
		this.pendingCount = pendingCount;
	}
	
	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the isPublished
	 */
	public byte getIsPublished() {
		return isPublished;
	}

	/**
	 * @param isPublished the isPublished to set
	 */
	public void setIsPublished(byte isPublished) {
		this.isPublished = isPublished;
	}

	/**
	 * @return the publishedUserId
	 */
	public long getPublishedUserId() {
		return publishedUserId;
	}

	/**
	 * @param publishedUserId the publishedUserId to set
	 */
	public void setPublishedUserId(long publishedUserId) {
		this.publishedUserId = publishedUserId;
	}

	/**
	 * @return the datePublished
	 */
	public Date getDatePublished() {
		return datePublished;
	}

	/**
	 * @param datePublished the datePublished to set
	 */
	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}
}