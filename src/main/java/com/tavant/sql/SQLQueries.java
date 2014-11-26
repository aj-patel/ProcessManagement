package com.tavant.sql;


import java.util.List;

public interface SQLQueries {

	public String getAddUserQuery();
	
	public String getUserDetailsQuery();
	
	public String getCreateTask();
	
	public String getTaskQuery(String steps);
	
	public String getCompleteTaskQuery();
	
	public String getRoleIdByUser();
	
	public String getStepsByRole();
	
	public String getTaskProgressByUser();
	
	public String getTask(String steps);
	
	public String createTaskProgressQuery();
	
	public String updateTaskQuery();
	
	public String getProcessInstanceQuery();
	
	public String getTaskCompleteQuery();
	
	public String getProcessCompleteQuery();
	
	public String getEndTaskQuery();
	
	public String getAllProcessListQuery();

	public String getTaskIdsForRoleId();

	public String getTaskListFromProcessInstance();
	
	public String getTaskDetailsByTaskId();
	
	public String getFirstTaskQuery();
	
	public String getProcessInstanceUpdateQuery();
	
	public String getTaskQuery();


}
