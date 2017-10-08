package com.srs.bean;

public class CreateApplicationBean {
	private String applicationName;
	private String applicationDetails;
	private String skillSet;
	private String designation;
	private String location;
	private boolean selectedInterview=false;
	
	
	
	
	
	
	public boolean isSelectedInterview() {
		return selectedInterview;
	}
	public void setSelectedInterview(boolean selectedInterview) {
		this.selectedInterview = selectedInterview;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}
	
	public String getApplicationName() {
		return applicationName;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
