package com.tavant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tavant.dao.ProcessInstanceDao;
import com.tavant.dao.RoleDao;
import com.tavant.dao.TaskDao;
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
	
}
