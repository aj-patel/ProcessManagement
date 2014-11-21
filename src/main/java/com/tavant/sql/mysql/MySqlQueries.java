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
	
	@Override
	public String getTaskQuery(String steps) {
		return "SELECT tp.tpid, t.tname, tp.step FROM taskprogress tp JOIN task t ON tp.tid = t.tid WHERE tp.status='completed' AND tp.step IN ("+steps+")";
	}
	
	@Override
	public String getCompleteTaskQuery() {
		return "UPDATE taskprogress set comment=? WHERE tpid=?";
	}
	
	@Override
	public String getRoleIdByUser() {
		return "SELECT rid FROM user WHERE uid=?";
	}
	
	@Override
	public String getStepsByRole() {
		return "SELECT snumber FROM step WHERE rid=?";
	}

	@Override
	public String getTaskProgressByUser() {
		return "SELECT t.tname, tp.comment, tp.step FROM task t JOIN taskprogress tp ON t.tid = tp.tid WHERE tp.status= 'inprogress' AND tp.uid = ?";
	}
}
