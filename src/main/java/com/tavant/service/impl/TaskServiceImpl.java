package com.tavant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tavant.dao.TaskDao;
import com.tavant.domain.ProcessDetails;
import com.tavant.domain.TaskDetails;
import com.tavant.domain.TaskProgressDetails;
import com.tavant.service.TaskService;

public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDao taskDao;
	
	@Override
	public boolean completeTask(String comment, String tId, int step) {
		return taskDao.completeStep(comment, tId, step);
	}

	@Override
	public TaskProgressDetails getTaskProgress(String userId) {
		return taskDao.getTaskProgress(userId);
	}
	
	@Override
	public TaskDetails getTaskDetails(int taskId) {
		
		return taskDao.getTaskDetails(taskId);
	}
}
