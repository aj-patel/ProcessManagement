package com.tavant.dao;

import java.util.List;

public interface RoleDao {
	
	public List<Integer> getTaskIdsForRoleId(int roleId);

}
