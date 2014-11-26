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
	
	public String getAllProcessListQuery();

	public String getTaskIdsForRoleId();

	public String getTaskListFromProcessInstance();
}
