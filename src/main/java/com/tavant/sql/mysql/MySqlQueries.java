package com.tavant.sql.mysql;
import com.tavant.sql.SQLQueries;

public class MySqlQueries implements SQLQueries {

	public String getAddUserQuery() {
		return "INSERT INTO user "
				+ "(uid, uname, rid,password) VALUES (?, ?, ?,?)";
	}

	public String getUserDetailsQuery() {
		return "SELECT * FROM user WHERE uname = ? AND password = ?";
	}
	
	@Override
	public String getCreateTask() {
		return "insert into task " + "(tname,status,step) values (?,?,?)";
	}
}
