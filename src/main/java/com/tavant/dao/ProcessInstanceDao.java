package com.tavant.dao;

import java.util.List;
import java.util.Map;

import com.tavant.domain.ApplicantDetails;
import com.tavant.domain.ProcessInstanceDetails;
import com.tavant.exception.ResourceNotFoundException;

public interface ProcessInstanceDao {
	
	public List<Map> getTasksIdsFromProcessInst(List taskIds) throws ResourceNotFoundException;
	
	public void updateProcessInstanceWithUserId(int processInstanceId, int userId) throws ResourceNotFoundException;
	
	public int insertApplicantDetails(ApplicantDetails applicantDetails) throws ResourceNotFoundException;
	
	public void createNewProcessInstance(ProcessInstanceDetails processInstance) throws ResourceNotFoundException;

	public ProcessInstanceDetails getProcessInstanceForUserId(int userId) throws ResourceNotFoundException; 

}
