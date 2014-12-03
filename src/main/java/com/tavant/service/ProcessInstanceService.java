package com.tavant.service;

import com.tavant.domain.ApplicantDetails;
import com.tavant.domain.ProcessDetails;
import com.tavant.domain.ProcessInstanceDetails;
import com.tavant.exception.ResourceNotFoundException;

import java.util.Map;

public interface ProcessInstanceService {
	
	public Map getNextTask(int roleId) throws ResourceNotFoundException;
	
	public void updateProcessInstanceWithUserId(int processInstanceId, int userId) throws ResourceNotFoundException;
	
	public void createProcessInstance(ProcessInstanceDetails processInstanceDetails, ApplicantDetails applicantDetails) throws ResourceNotFoundException;
	
	public ProcessInstanceDetails isUserFree(int userId) throws ResourceNotFoundException;
}
