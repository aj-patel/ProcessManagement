package com.tavant.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.tavant.dao.TaskDao;
import com.tavant.domain.ProcessDetails;
import com.tavant.domain.TaskDetails;
import com.tavant.domain.TaskProgressDetails;
import com.tavant.sql.SQLQueries;

public class TaskDAOImpl implements TaskDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SQLQueries sqlQueries;
	
	
	@Override
	public void addTask(final TaskDetails taskDetails) {

		jdbcTemplate.update(sqlQueries.getCreateTask(), new Object[] { taskDetails.getTaskName(),taskDetails.getStatus(),taskDetails.getStep()});
		
	}
	
	@Override
	public TaskDetails getTask(String userId) {
		Object[] args = new Object[1];
		args[0] = userId;
		List<Map> rows = jdbcTemplate.queryForList(sqlQueries.getTaskProgressByUser(),args);
		if(null!=rows && rows.size()>0){
			String tid = null, tname = null, comment;
			int step=0;
			for(Map map:rows){
				tid = (String)map.get("tid");
				tname = (String) map.get("tname");
				comment = (String) map.get("comment");
				step =  (int) map.get("step");
			}
			return new TaskDetails(tid, tname,null, new Integer(step),null,null);
		}
		
		String roleId = (String)jdbcTemplate.queryForObject(sqlQueries.getRoleIdByUser(), new Object[] {userId},String.class);
		System.out.println("Role returned is :"+roleId);
		args[0] = roleId;
		
		List<Map> listMap = jdbcTemplate.queryForList(sqlQueries.getStepsByRole(), args);
		String param = "";
		for(Map map:listMap){
			param = param+map.get("snumber")+",";
		}
		param = param.substring(0, param.length()-1);
		
		String tid = null, tname = null;
		List<Map> listTask = jdbcTemplate.queryForList(sqlQueries.getTask(param)); 
		int step = 0;
		if(null!=listTask && listTask.size()>0){
			
			for(Map map:listTask){
				tid = (String)map.get("tid");
				tname = (String) map.get("tname");
				step = (int) map.get("step");
			}
			jdbcTemplate.update(sqlQueries.createTaskProgressQuery(), new Object[]{userId,tid,step,"inprogress",new Date()});
			
			return new TaskDetails(tid, tname,null, step,null,null);
		}
		return null;
	}

	
	@Override
	public boolean completeStep(String comment, String tId, int step) {
		int res = jdbcTemplate.update(sqlQueries.getCompleteTaskQuery(),new Object[]{comment,new Date(),tId});
		if(res==1){
			++step;
			int r = jdbcTemplate.update(sqlQueries.updateTaskQuery(),new Object[]{step,tId});
			if(r==1){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public TaskProgressDetails getTaskProgress(String userId) {
		Object[] args = new Object[1];
		args[0] = userId;
		SqlRowSet taskProgress = jdbcTemplate.queryForRowSet(sqlQueries.getTaskProgressByUser(),args);

		if(null!=taskProgress){
			String tname = taskProgress.getString(0);
			String comment = taskProgress.getString(1);
			String step = taskProgress.getString(2);
			return new TaskProgressDetails(tname, comment, step);
		}else{
			return null;			
		}
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
}
