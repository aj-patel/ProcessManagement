package com.tavant.sql;



public interface SQLQueries {

	public String getAddUserQuery();
	
	public String getUserDetailsQuery();
	
	public String getCompleteTaskQuery();
	
	public String updateTaskQuery();
	
	public String getProcessInstanceQuery();
	
	public String getTaskCompleteQuery();
	
	public String getProcessCompleteQuery();
	
	public String getAllProcessListQuery();

	public String getTaskIdsForRoleId();

	public String getTaskListFromProcessInstance();
	
	public String getTaskDetailsByTaskId();
	
	public String getFirstTaskQuery();
	
	public String getProcessInstanceUpdateQuery();
	
	public String getTaskQuery();

	public String createProcessInstanceQuery();
	
	public String updateProcessInstance();
	
	public String deleteProcessInstanceQuery();
	
	public String getProcessInstanceForUserId();

}
