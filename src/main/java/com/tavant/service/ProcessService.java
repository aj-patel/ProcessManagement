package com.tavant.service;

import java.util.List;

import com.tavant.domain.ProcessDetails;
import com.tavant.exception.ResourceNotFoundException;

public interface ProcessService {
	
	boolean updateProcessInstance(String prcId,String status, String comment) throws ResourceNotFoundException;
	
	public List<ProcessDetails> getProcessList() throws ResourceNotFoundException;
}
