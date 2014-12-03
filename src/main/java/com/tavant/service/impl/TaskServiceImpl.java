package com.tavant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tavant.dao.TaskDao;
import com.tavant.domain.TaskDetails;
import com.tavant.exception.ResourceNotFoundException;
import com.tavant.service.TaskService;

public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDao taskDao;
	
	@Override
	public boolean completeTask(String comment, String tId, int step) throws ResourceNotFoundException{
		try{
			return taskDao.completeStep(comment, tId, step);
		} catch (ResourceNotFoundException e){
			throw e;
		}
	}

	@Override
	public TaskDetails getTaskDetails(int taskId) throws ResourceNotFoundException{
		try{
			return taskDao.getTaskDetails(taskId);
		} catch (ResourceNotFoundException e){
			throw e;
		}
	}
}
