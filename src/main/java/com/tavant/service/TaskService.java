package com.tavant.service;

import com.tavant.domain.TaskDetails;
import com.tavant.exception.ResourceNotFoundException;

public interface TaskService {

	public boolean completeTask(String comment, String tid, int step) throws ResourceNotFoundException;
	
	public TaskDetails getTaskDetails(int taskId) throws ResourceNotFoundException;
	
}
