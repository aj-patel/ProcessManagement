package com.tavant.sql.mysql;
import com.tavant.sql.SQLQueries;

public class MySqlQueries implements SQLQueries {

	public String getAddUserQuery() {
		return "INSERT INTO user "
				+ "(uid, uname, rid,password) VALUES (?, ?, ?,?)";
	}

	public String getAddTaskQuery() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getUserDetailsQuery() {
		return "SELECT * FROM user WHERE uname = ? AND password = ?";
	}
}
