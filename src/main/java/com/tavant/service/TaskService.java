package com.tavant.service;

import java.util.List;

import com.tavant.domain.ProcessDetails;
import com.tavant.domain.TaskDetails;
import com.tavant.domain.TaskProgressDetails;

public interface TaskService {

	/*public void addTask(final TaskDetails taskDetails);
	
	public TaskDetails getTask(String userId);*/
	
	public boolean completeTask(String comment, String tid, int step);
	
	public TaskProgressDetails getTaskProgress(String userId);
	
	public List<ProcessDetails> getProcessList();
	
	public TaskDetails getTaskDetails(int taskId);
	
}
