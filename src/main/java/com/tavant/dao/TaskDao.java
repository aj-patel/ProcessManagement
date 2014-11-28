package com.tavant.dao;

import com.tavant.domain.TaskDetails;
import com.tavant.domain.TaskProgressDetails;

public interface TaskDao {
	
	public boolean completeStep(String comment, String tId, int step);
	
	public TaskDetails getTaskDetails(int taskId);
	
	public TaskDetails getFirstTask(int processId);
	
	
}
