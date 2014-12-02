package com.tavant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.tavant.dao.ProcessDao;
import com.tavant.domain.ProcessDetails;
import com.tavant.domain.ProcessInstanceDetails;
import com.tavant.domain.TaskDetails;
import com.tavant.sql.SQLQueries;

public class ProcessDAOImpl implements ProcessDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SimpleJdbcInsert simpleJdbcInsert ;
	
	@Autowired
	private SQLQueries sqlQueries;
	
	public boolean updateProcessInstance(String prcId,String status, String comment){
		ProcessInstanceDetails processInstanceDetails=null;
		
		try{
			processInstanceDetails = (ProcessInstanceDetails) jdbcTemplate.queryForObject(sqlQueries.getProcessInstanceQuery(), new Object[] { prcId }, new ProcessInstanceMapper());
		} catch (EmptyResultDataAccessException e) {
		}
		int resTaskHistory = 0;
		int resProcessInstance = 0;
		int resProcessHistory = 0;
		int resDeleteProcessInstance=0;
		
		if(null!=processInstanceDetails && processInstanceDetails.getUsr_id()!=null &&  processInstanceDetails.getUsr_id()>0){
			resTaskHistory = jdbcTemplate.update(sqlQueries.getTaskCompleteQuery(), new Object[]{processInstanceDetails.getTsk_id(),processInstanceDetails.getApp_id(),processInstanceDetails.getUsr_id(),status,comment,processInstanceDetails.getTsk_start_dt(),new Date(),processInstanceDetails.getPrc_id()});
		

		if(null!=processInstanceDetails.getNext_task_id() && processInstanceDetails.getNext_task_id()>0){
			TaskDetails taskDetails = (TaskDetails) jdbcTemplate.queryForObject(sqlQueries.getTaskQuery(), new Object[] { processInstanceDetails.getNext_task_id()}, new TaskDetailsMapper());
			if(null!=taskDetails){
				resProcessInstance = jdbcTemplate.update(sqlQueries.getProcessInstanceUpdateQuery(), new Object[]{taskDetails.getTsk_id(),null,new Date(),taskDetails.getNext_task_id(), processInstanceDetails.getPri_id()});
			}
			return (resTaskHistory==1&&resProcessInstance==1)==true?true:false;
		}else{
			resProcessHistory = jdbcTemplate.update(sqlQueries.getProcessCompleteQuery(), new Object[]{processInstanceDetails.getPrc_id(), processInstanceDetails.getApp_id(), status,processInstanceDetails.getPrc_start_dt(), new Date() });
			resDeleteProcessInstance = jdbcTemplate.update(sqlQueries.deleteProcessInstanceQuery(), new Object[]{processInstanceDetails.getPri_id()});
			return (resTaskHistory==1&&resProcessHistory==1&&resDeleteProcessInstance==1)==true?true:false;
		}
		}
		return false;
		
	}
	
	@Override
	public List<ProcessDetails> getProcessList(){
		List<ProcessDetails> processList = new ArrayList<ProcessDetails>();
		List<Map> rows = jdbcTemplate.queryForList(sqlQueries.getAllProcessListQuery(), new Object[]{});
		if(null!=rows && rows.size()>0){
			
			for(Map map : rows){
				processList.add(new ProcessDetails((int)map.get("prc_id"), (String)map.get("prc_name"), null));
			}
		}
		return processList;
	}
	
	private class ProcessInstanceMapper implements RowMapper {
		public ProcessInstanceDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProcessInstanceDetails processInstanceDetails = new ProcessInstanceDetails(rs.getInt("pri_id"),rs.getInt("app_id"),rs.getInt("tsk_id"),rs.getInt("usr_id"),rs.getInt("prc_id"),rs.getInt("next_task_id"),rs.getDate("tsk_start_dt"), rs.getDate("prc_start_dt"));
			return processInstanceDetails;
		}
	}
	
	private class TaskDetailsMapper implements RowMapper {
		public TaskDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			TaskDetails taskDetails = new TaskDetails(rs.getInt("tsk_id"),rs.getInt("prc_id"),rs.getString("tsk_name"),rs.getString("tsk_desc"),rs.getInt("next_task_id"), rs.getInt("srt_and_end"));
			return taskDetails;
		}
	}

}
