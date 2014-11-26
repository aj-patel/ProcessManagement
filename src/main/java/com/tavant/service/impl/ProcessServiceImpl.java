package com.tavant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tavant.dao.ProcessDao;
import com.tavant.domain.ProcessDetails;
import com.tavant.service.ProcessService;

public class ProcessServiceImpl implements ProcessService {

	@Autowired
	private ProcessDao processDao;
	
	@Override
	public boolean updateProcessInstance(String prcId,String status, String comment) {
		return processDao.updateProcessInstance(prcId,status,comment);
	}
	
	@Override
	public List<ProcessDetails> getProcessList(){
		return processDao.getProcessList();
	}

}
