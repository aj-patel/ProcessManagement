package com.tavant.dao;

public interface ProcessDao {
	
	public boolean updateProcessInstance(String prcId, String status, String comment);
}
