package com.tavant.domain;


/**
 * @author connecttoaj
 *Domain class for userdetails.
 */
public class UserDetails {
	
		private String userId;
		
		private String userName;
		
		private String roleId;
		
		private String password;
		
		private byte[] encPassword; 
		
		private  byte[] salt;
		
		public UserDetails() {
		}

		public UserDetails(String userId, String userName, String roleId,
				String password, byte[] encPassword, byte[] salt) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.roleId = roleId;
			this.password = password;
			this.encPassword = encPassword;
			this.salt = salt;
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

		public String getRoleId() {
			return roleId;
		}

		public void setRoleId(String roleId) {
			this.roleId = roleId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public byte[] getEncPassword() {
			return encPassword;
		}

		public void setEncPassword(byte[] encPassword) {
			this.encPassword = encPassword;
		}

		public byte[] getSalt() {
			return salt;
		}

		public void setSalt(byte[] salt) {
			this.salt = salt;
		}

}
