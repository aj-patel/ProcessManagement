package com.tavant.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import com.tavant.dao.ProcessInstanceDao;
import com.tavant.dao.RoleDao;
import com.tavant.dao.TaskDao;
import com.tavant.domain.ApplicantDetails;
import com.tavant.domain.ProcessDetails;
import com.tavant.domain.ProcessInstanceDetails;
import com.tavant.domain.TaskDetails;
import com.tavant.exception.ResourceNotFoundException;
import com.tavant.service.ProcessInstanceService;

public class ProcessInstanceServiceImpl implements ProcessInstanceService {

	@Autowired
	private ProcessInstanceDao processInstanceDao;
	
	@Autowired
	private TaskDao taskDAO;
	
	@Autowired
	private RoleDao roleDAO;
	
	@Override
	public Map getNextTask(int roleId) throws ResourceNotFoundException{
		List<Integer> taskIds = roleDAO.getTaskIdsForRoleId(roleId);
		try {
			List<Map> taskIdsFromProcessInstId = processInstanceDao.getTasksIdsFromProcessInst(taskIds);
			if (taskIdsFromProcessInstId != null && taskIdsFromProcessInstId.size() != 0) {
				return taskIdsFromProcessInstId.get(0);
			}
		} catch (ResourceNotFoundException e) {
			throw e;
		}
		return null;
	}
	@Override
	public void updateProcessInstanceWithUserId(int processInstanceId, int userId) throws ResourceNotFoundException{
		try{
			processInstanceDao.updateProcessInstanceWithUserId(processInstanceId, userId);
		} catch (ResourceNotFoundException e) {
			throw e;
		}
	}
	
	@Override
	public void createProcessInstance(ProcessInstanceDetails processInstance, ApplicantDetails applicantDetails) throws ResourceNotFoundException{
		try{
			int applicantId = processInstanceDao.insertApplicantDetails(applicantDetails);
			processInstance.setApp_id(applicantId);
			TaskDetails taskDetail = taskDAO.getFirstTask(processInstance.getPrc_id());
			processInstance.setTsk_id(taskDetail.getTsk_id());
			processInstance.setNext_task_id(taskDetail.getNext_task_id());
			processInstanceDao.createNewProcessInstance(processInstance);
		} catch (ResourceNotFoundException e) {
			throw e;
		}
	}
	@Override
	public ProcessInstanceDetails isUserFree(int userId) throws ResourceNotFoundException{
		try{
			return processInstanceDao.getProcessInstanceForUserId(userId);
		} catch (ResourceNotFoundException e) {
			throw e;
		}
	}
}
