package com.tavant.service;

import com.tavant.domain.ApplicantDetails;
import com.tavant.domain.ProcessDetails;
import com.tavant.domain.ProcessInstanceDetails;
import java.util.Map;

public interface ProcessInstanceService {
	
	public Map getNextTask(int roleId);
	
	public void updateProcessInstanceWithUserId(int processInstanceId, int userId);
	
	public void createProcessInstance(ProcessInstanceDetails processInstanceDetails, ApplicantDetails applicantDetails);
	
	public boolean isUserFree(int userId);
}
