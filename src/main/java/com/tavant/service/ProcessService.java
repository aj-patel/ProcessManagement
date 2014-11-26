package com.tavant.service;

import java.util.List;

import com.tavant.domain.ProcessDetails;

public interface ProcessService {
	
	boolean updateProcessInstance(String prcId,String status, String comment);
	
	public List<ProcessDetails> getProcessList();
}
