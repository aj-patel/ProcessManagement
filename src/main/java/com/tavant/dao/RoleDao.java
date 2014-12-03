package com.tavant.dao;

import java.util.List;

import com.tavant.exception.ResourceNotFoundException;

public interface RoleDao {
	
	public List<Integer> getTaskIdsForRoleId(int roleId) throws ResourceNotFoundException;

}
