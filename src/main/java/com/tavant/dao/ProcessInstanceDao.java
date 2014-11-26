package com.tavant.dao;

import java.util.List;

import com.tavant.domain.ApplicantDetails;

public interface ProcessInstanceDao {
	
	public List<Integer> getTasksIdsFromProcessInst(List taskIds);
	
	public int insertApplicantDetails(ApplicantDetails applicantDetails);

}
