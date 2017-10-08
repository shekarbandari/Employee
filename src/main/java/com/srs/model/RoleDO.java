package com.srs.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tblrole database table.
 * 
 */
@Entity
@Table(name="tblrole")
@NamedQuery(name="RoleDO.findAll", query="SELECT t FROM RoleDO t")
public class RoleDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int roleId;

	@Column(length=512)
	private String comments;

	@Column(nullable=false)
	private long createdUserId;

	@Column(nullable=false)
	private Timestamp dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datePublished;

	@Column(nullable=false, length=64)
	private String IPAddress;

	/*@Column(nullable=false)
	private byte isDisplayOnWeb;*/

	@Column(nullable=false)
	private int isPublished;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdated;

	private long publishedUserId;

	@Column(length=50)
	private String roleCode;

	@Column(length=1024)
	private String roleDescription;

	@Column(nullable=false, length=128)
	private String roleName;

	/*@Column(nullable=false)
	private long sortOrder;

	@Column(length=128)
	private String tag;*/

	private long updatedUserId;

	
	//bi-directional many-to-one association to Tbluserrole
	@OneToMany(mappedBy="tblrole")
	private List<UserRoleDO> tbluserroles;

	public RoleDO() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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

	public Timestamp getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDatePublished() {
		return this.datePublished;
	}

	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
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

	public int getIsPublished() {
		return this.isPublished;
	}

	public void setIsPublished(int isPublished) {
		this.isPublished = isPublished;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public long getPublishedUserId() {
		return this.publishedUserId;
	}

	public void setPublishedUserId(long publishedUserId) {
		this.publishedUserId = publishedUserId;
	}

	public String getRoleCode() {
		return this.roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDescription() {
		return this.roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
/*
	public long getSortOrder() {
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

	
	public List<UserRoleDO> getTbluserroles() {
		return this.tbluserroles;
	}

	public void setTbluserroles(List<UserRoleDO> tbluserroles) {
		this.tbluserroles = tbluserroles;
	}

	public UserRoleDO addTbluserrole(UserRoleDO tbluserrole) {
		getTbluserroles().add(tbluserrole);
		tbluserrole.setTblrole(this);

		return tbluserrole;
	}

	public UserRoleDO removeTbluserrole(UserRoleDO tbluserrole) {
		getTbluserroles().remove(tbluserrole);
		tbluserrole.setTblrole(null);

		return tbluserrole;
	}

}