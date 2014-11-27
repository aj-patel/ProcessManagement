package com.tavant.dao;

import java.util.List;
import java.util.Map;

import com.tavant.domain.ApplicantDetails;
import com.tavant.domain.ProcessInstanceDetails;

public interface ProcessInstanceDao {
	
	public List<Map> getTasksIdsFromProcessInst(List taskIds);
	
	public void updateProcessInstanceWithUserId(int processInstanceId,
			int userId);
	
	public int insertApplicantDetails(ApplicantDetails applicantDetails);
	
	public void createNewProcessInstance(ProcessInstanceDetails processInstance);

	public ProcessInstanceDetails getProcessInstanceForUserId(int userId); 

}
