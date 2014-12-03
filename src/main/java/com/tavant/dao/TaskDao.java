package com.tavant.dao;

import com.tavant.domain.TaskDetails;
import com.tavant.domain.TaskProgressDetails;
import com.tavant.exception.ResourceNotFoundException;

public interface TaskDao {
	
	public boolean completeStep(String comment, String tId, int step) throws ResourceNotFoundException;
	
	public TaskDetails getTaskDetails(int taskId) throws ResourceNotFoundException;
	
	public TaskDetails getFirstTask(int processId) throws ResourceNotFoundException;
	
	
}
