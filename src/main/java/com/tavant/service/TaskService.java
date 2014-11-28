package com.tavant.service;

import com.tavant.domain.TaskDetails;

public interface TaskService {

	public boolean completeTask(String comment, String tid, int step);
	
	public TaskDetails getTaskDetails(int taskId);
	
}
