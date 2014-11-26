package com.tavant.dao.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.tavant.dao.ProcessInstanceDao;
import com.tavant.sql.SQLQueries;

public class ProcessInstanceDAOImpl implements ProcessInstanceDao{
	
	
	@Autowired
	private SQLQueries sqlQueries;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Integer> getTasksIdsFromProcessInst(List taskIds) {
		// TODO Auto-generated method stub
		

		Map<String, List> param = Collections.singletonMap("taskIds",taskIds);        
		NamedParameterJdbcTemplate  namedParameterJdbcTemplate = new  
		NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
		String sql = "SELECT bg.goodsid FROM beiker_goods bg WHERE bg.goodsid in(:goodsid)";
		List<Integer> list = namedParameterJdbcTemplate.queryForList(sqlQueries.getTaskListFromProcessInstance(), param, Integer.class);

		return list;
	}
}
