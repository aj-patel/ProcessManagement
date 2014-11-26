package com.tavant.dao;

import java.util.List;

import com.tavant.domain.ProcessDetails;

public interface ProcessDao {
	
	public boolean updateProcessInstance(String prcId, String status, String comment);
	
	public List<ProcessDetails> getProcessList();
	
}
