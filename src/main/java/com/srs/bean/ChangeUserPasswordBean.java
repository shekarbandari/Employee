package com.srs.bean;

import javax.validation.constraints.Pattern;


public class ChangeUserPasswordBean {
	private String oldPassword;
	
	/* password policy */
	// min 8 characters
	// at least 1 uppercase letter
	// at least 1 lowercase letter
	// at least 1 special character from !_@#$%^&+=
	// no white space
	/*@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!_@#$%^&+=])(?=[\\S]+$).{8,}$", 
			message = "Invalid combination. Password should contain min. 8 characters, atleast 1 lowercase letter, "
					+ "atleast 1 uppercase letter, atleast 1 special character(!_@#$%^&+=) "
					+ "and should not contain any blank space.")
*/
	private String password;
	private String confirmPassword;
	
	private String userId;
	private String userName;
	
	
	
	
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
