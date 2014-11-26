package com.tavant.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tavant.dao.RoleDao;
import com.tavant.sql.SQLQueries;

public class RoleDAOImpl implements RoleDao{

	@Autowired
	private SQLQueries sqlQueries;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Integer> getTaskIdsForRoleId(int roleId) {
		// TODO Auto-generated method stub
		return (List<Integer>)jdbcTemplate.queryForList(sqlQueries.getTaskIdsForRoleId(), new Object[] { roleId },Integer.class);
	}
	
}
