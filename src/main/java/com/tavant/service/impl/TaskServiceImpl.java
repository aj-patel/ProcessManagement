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
	public void addTask(final TaskDetails taskDetails) {
		
		taskDao.addTask(taskDetails);
		
	}
	
	@Override
	public TaskDetails getTask(String userId) {
		return taskDao.getTask(userId);
	}

	@Override
	public boolean completeTask(String comment, String tId, int step) {
		return taskDao.completeStep(comment, tId, step);
	}

	@Override
	public TaskProgressDetails getTaskProgress(String userId) {
		return taskDao.getTaskProgress(userId);
	}
	
	@Override
	public List<ProcessDetails> getProcessList(){
		return taskDao.getProcessList();
	}

}
