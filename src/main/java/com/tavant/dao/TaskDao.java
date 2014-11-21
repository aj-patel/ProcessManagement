package com.tavant.dao;

import com.tavant.domain.TaskDetails;
import com.tavant.domain.TaskProgressDetails;

public interface TaskDao {
	
	public void addTask(final TaskDetails taskDetails);
	
	public TaskDetails getTask(String userId);
	
	public boolean completeStep(String comment, String tpId);
	
	public TaskProgressDetails getTaskProgress(String userId);

}
