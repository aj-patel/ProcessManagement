package com.tavant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tavant.dao.TaskDao;
import com.tavant.domain.TaskDetails;
import com.tavant.domain.TaskProgressDetails;
import com.tavant.service.TaskService;

public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDao taskDao;
	
	@Override
	public void addTask(final TaskDetails taskDetails) {
		
		taskDao.addTask(taskDetails);
		
	}
	
	@Override
	public TaskDetails getTask(String userId) {
		return taskDao.getTask(userId);
	}

	@Override
	public boolean completeTask(String comment, String tpId) {
		return taskDao.completeStep(comment, tpId);
	}

	@Override
	public TaskProgressDetails getTaskProgress(String userId) {
		return taskDao.getTaskProgress(userId);
	}

}
