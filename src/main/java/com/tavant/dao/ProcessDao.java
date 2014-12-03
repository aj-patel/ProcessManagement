package com.tavant.dao;

import java.util.List;

import com.tavant.domain.ProcessDetails;
import com.tavant.exception.ResourceNotFoundException;

public interface ProcessDao {
	
	public boolean updateProcessInstance(String prcId, String status, String comment) throws ResourceNotFoundException;
	
	public List<ProcessDetails> getProcessList() throws ResourceNotFoundException;
	
}
