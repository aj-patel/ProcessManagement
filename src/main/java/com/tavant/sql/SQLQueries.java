package com.tavant.sql;

public interface SQLQueries {

	public String getAddUserQuery();
	
	public String getUserDetailsQuery();
	
	public String getCreateTask();
	
	public String getTaskQuery(String steps);
	
	public String getCompleteTaskQuery();
	
	public String getRoleIdByUser();
	
	public String getStepsByRole();
	
	public String getTaskProgressByUser();
	
}
