package com.tavant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tavant.dao.TaskDao;
import com.tavant.domain.TaskDetails;
import com.tavant.service.TaskService;

public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDao taskDao;
	
	@Override
	public void addTask(TaskDetails taskDetails) {
		
		taskDao.addTask(taskDetails);
		
	}

}
