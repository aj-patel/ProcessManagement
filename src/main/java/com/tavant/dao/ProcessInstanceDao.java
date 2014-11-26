package com.tavant.dao;

import java.util.List;

public interface ProcessInstanceDao {
	
	public List<Integer> getTasksIdsFromProcessInst(List taskIds);

}
