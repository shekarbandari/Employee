package com.srs.bean;

public class GeneralBean {
	// Email related info
		private String host;
		private String port;
		private String username;
		private String password;
		
		// SSDG related info
		private String ssdgURL;
		
		// SMS related info
		private String smsURL;
		private String smsSenderId;
		private String smsUserName;
		private String smsPassword;
		private String smsMessage;
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public String getPort() {
			return port;
		}
		public void setPort(String port) {
			this.port = port;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getSsdgURL() {
			return ssdgURL;
		}
		public void setSsdgURL(String ssdgURL) {
			this.ssdgURL = ssdgURL;
		}
		public String getSmsURL() {
			return smsURL;
		}
		public void setSmsURL(String smsURL) {
			this.smsURL = smsURL;
		}
		public String getSmsSenderId() {
			return smsSenderId;
		}
		public void setSmsSenderId(String smsSenderId) {
			this.smsSenderId = smsSenderId;
		}
		public String getSmsUserName() {
			return smsUserName;
		}
		public void setSmsUserName(String smsUserName) {
			this.smsUserName = smsUserName;
		}
		public String getSmsPassword() {
			return smsPassword;
		}
		public void setSmsPassword(String smsPassword) {
			this.smsPassword = smsPassword;
		}
		public String getSmsMessage() {
			return smsMessage;
		}
		public void setSmsMessage(String smsMessage) {
			this.smsMessage = smsMessage;
		}
		

}
