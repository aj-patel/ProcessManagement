package com.tavant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tavant.dao.ProcessInstanceDao;
import com.tavant.dao.RoleDao;
import com.tavant.dao.TaskDao;
import com.tavant.domain.ApplicantDetails;
import com.tavant.domain.ProcessDetails;
import com.tavant.domain.ProcessInstanceDetails;
import com.tavant.service.ProcessInstanceService;

public class ProcessInstanceServiceImpl implements ProcessInstanceService {

	@Autowired
	private ProcessInstanceDao processInstanceDao;
	
	@Autowired
	private TaskDao taskDAO;
	
	@Autowired
	private RoleDao roleDAO;
	
	@Override
	public Integer getNextTask(int roleId) {
		// TODO Auto-generated method stub
		List<Integer> taskIds = roleDAO.getTaskIdsForRoleId(roleId);
		List <Integer> taskIdsFromProcessInstId = processInstanceDao.getTasksIdsFromProcessInst(taskIds);
		if(taskIdsFromProcessInstId != null && taskIdsFromProcessInstId.size() !=0){
			return taskIdsFromProcessInstId.get(0);
		}
		return null;
	}
	
	@Override
	public void createProcessInstance(ProcessInstanceDetails processInstance, ApplicantDetails applicantDetails){
		int applicantId = processInstanceDao.insertApplicantDetails(applicantDetails);
		processInstance.setApp_id(applicantId);
		int taskId = taskDAO.getFirstTask(processInstance.getPrc_id());
		processInstance.setTsk_id(taskId);
	}
	
}
