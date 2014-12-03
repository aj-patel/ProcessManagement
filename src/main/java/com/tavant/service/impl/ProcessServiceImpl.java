package com.tavant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tavant.dao.ProcessDao;
import com.tavant.domain.ProcessDetails;
import com.tavant.exception.ResourceNotFoundException;
import com.tavant.service.ProcessService;

public class ProcessServiceImpl implements ProcessService {

	@Autowired
	private ProcessDao processDao;
	
	@Override
	public boolean updateProcessInstance(String prcId,String status, String comment) throws ResourceNotFoundException{
		try {
			return processDao.updateProcessInstance(prcId, status, comment);
		} catch (ResourceNotFoundException e) {
			throw e;
		}
	}
	
	@Override
	public List<ProcessDetails> getProcessList() throws ResourceNotFoundException{
		try {
			return processDao.getProcessList();
		} catch (ResourceNotFoundException e) {
			throw e;
		}
	}

}
