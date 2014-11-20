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

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UserDetails(String userId, String userName, String roleId,
			String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.roleId = roleId;
		this.password = password;
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
	
}
