package com.tavant.sql.mysql;
import com.tavant.sql.SQLQueries;

public class MySqlQueries implements SQLQueries {

	public String getAddUserQuery() {
		return "INSERT INTO user (usr_name, rol_id, usr_pass, salt) VALUES (?, ?, ?, ?)";
	} 

	public String getUserDetailsQuery() {
		return "SELECT * FROM user WHERE usr_name = ? ";
	}
	
	
	@Override
	public String getCompleteTaskQuery() {
		return "UPDATE taskprogress set comment=?, status='completed', edate=? WHERE tid=?";
	}
	
	@Override
	public String updateTaskQuery() {
		return "UPDATE task t SET t.status='new', t.step=? WHERE t.tid = ?";
	}

	@Override
	public String getProcessInstanceQuery() {
		return "SELECT * FROM process_instance WHERE pri_id=?";
	}

	@Override
	public String getTaskCompleteQuery() {
		return "INSERT INTO task_history (tsk_id,app_id,usr_id,status,comment,srt_dt,end_dt,prc_id) values(?,?,?,?,?,?,?,?)";
	}

	@Override
	public String getProcessCompleteQuery() {
		 return "INSERT INTO process_history (prc_id,app_id,status,srt_dt,end_dt) values(?,?,?,?,?)";
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
		return "select tsk_id, pri_id from process_instance where tsk_id in (:taskIds) and usr_id IS NULL";
	}
	@Override
	public String getTaskDetailsByTaskId() {
		// TODO Auto-generated method stub
		return "select * from task where tsk_id=?";
	}
	@Override
	public String getFirstTaskQuery(){
		return "select tsk_id, next_task_id from task where prc_id = ? and srt_and_end = 0";
	}
	
	@Override
	public String getProcessInstanceUpdateQuery() {
		return "UPDATE process_instance SET tsk_id=?, usr_id=?,tsk_start_dt=?, next_task_id=? WHERE pri_id=?";
	}

	@Override
	public String getTaskQuery() {
		return "SELECT * FROM task WHERE tsk_id=?";
	}
	
	@Override
	public String createProcessInstanceQuery(){
		return "INSERT INTO process_instance (app_id, tsk_id, prc_id, prc_start_dt, next_task_id) values(?, ?, ?, ?, ?)";
		
	}
	
	@Override
	public String updateProcessInstance() {
		// TODO Auto-generated method stub
		return "UPDATE process_instance SET usr_id=?,tsk_start_dt=? WHERE pri_id=?";
	}
	
	@Override
	public String deleteProcessInstanceQuery() {
		return "DELETE FROM `process_instance` WHERE pri_id=?;";
	}
	
	public String getProcessInstanceForUserId() {
		return "select * from process_instance where usr_id =?";
	}
}
