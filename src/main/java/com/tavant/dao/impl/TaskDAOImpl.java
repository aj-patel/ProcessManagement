package com.tavant.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tavant.dao.TaskDao;
import com.tavant.domain.TaskDetails;

public class TaskDAOImpl implements TaskDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void addTask(TaskDetails taskDetails) {
		// TODO Auto-generated method stub
		
	}
}
