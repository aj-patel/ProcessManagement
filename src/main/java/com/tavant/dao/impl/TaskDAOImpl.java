package com.tavant.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tavant.dao.TaskDao;
import com.tavant.domain.TaskDetails;
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
}
