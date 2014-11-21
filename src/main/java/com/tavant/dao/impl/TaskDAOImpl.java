package com.tavant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.tavant.dao.TaskDao;
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
		SqlRowSet setRole = jdbcTemplate.queryForRowSet(sqlQueries.getRoleIdByUser(),args);
		
		String roleId = setRole.getString("rid");
		args[0] = roleId;
		SqlRowSet setSteps = jdbcTemplate.queryForRowSet(sqlQueries.getStepsByRole(),args);
		
		ResultSet resultSet = (ResultSet)jdbcTemplate.queryForRowSet(sqlQueries.getTaskQuery("1,2,3")); 
		String tpId = null;
		String tName = null;
		int step = 0;
		try {
			tpId = resultSet.getString(0);
			tName = resultSet.getString(1);
			step = Integer.parseInt(resultSet.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return new TaskDetails(tpId, tName,null, new Integer(step).toString(),null,null);
	}

	
	@Override
	public boolean completeStep(String comment, String tpId) {
		int res = jdbcTemplate.update(sqlQueries.getCompleteTaskQuery(),new Object[]{comment,tpId});
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
}
