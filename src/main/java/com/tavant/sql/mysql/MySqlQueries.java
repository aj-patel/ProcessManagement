package com.tavant.sql.mysql;
import java.util.List;

import com.tavant.sql.SQLQueries;

public class MySqlQueries implements SQLQueries {

	public String getAddUserQuery() {
		return "INSERT INTO user "
				+ "(uname, rid,password) VALUES (?, ?,?)";
	}

	public String getUserDetailsQuery() {
		return "SELECT * FROM user WHERE usr_name = ? AND usr_pass = ?";
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
		return "UPDATE taskprogress set comment=?, status='completed', edate=? WHERE tid=?";
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
		return "SELECT t.tid, t.tname, tp.comment, tp.step FROM task t JOIN taskprogress tp ON t.tid = tp.tid WHERE tp.status= 'inprogress' AND tp.uid = ?";
	}

	@Override
	public String getTask(String steps) {
		return "SELECT t.tid, t.tname, t.step FROM task t WHERE t.status='new' AND t.step IN ("+steps+")";
	}

	@Override
	public String createTaskProgressQuery() {
		return "INSERT INTO taskprogress (uid,tid,step,status,sdate) values(?,?,?,?,?)";
	}

	@Override
	public String updateTaskQuery() {
		return "UPDATE task t SET t.status='new', t.step=? WHERE t.tid = ?";
	}
	@Override
	public String getAllProcessListQuery(){
		return "SELECT p.prc_id, p.prc_name FROM process p";
	}
	@Override
	public String getTaskIdsForRoleId() {
		// TODO Auto-generated method stub
		return "select tsk_id from role_task where rol_id = ?";
	}
	@Override
	public String getTaskListFromProcessInstance() {
		// TODO Auto-generated method stub
		return "select tsk_id from process_instance where tsk_id in (:taskIds) and usr_id IS NULL;";
	}
}
