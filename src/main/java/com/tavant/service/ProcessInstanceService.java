package com.tavant.service;

import com.tavant.domain.ApplicantDetails;
import com.tavant.domain.ProcessDetails;
import com.tavant.domain.ProcessInstanceDetails;

public interface ProcessInstanceService {
	
	public Integer getNextTask(int roleId);
	
	public void createProcessInstance(ProcessInstanceDetails processInstanceDetails, ApplicantDetails applicantDetails);

}
