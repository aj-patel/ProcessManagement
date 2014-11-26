package com.tavant.dao.impl;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.tavant.dao.ProcessInstanceDao;
import com.tavant.domain.ApplicantDetails;
import com.tavant.domain.ProcessInstanceDetails;
import com.tavant.sql.SQLQueries;

public class ProcessInstanceDAOImpl implements ProcessInstanceDao{
	
	
	@Autowired
	private SQLQueries sqlQueries;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    private SimpleJdbcInsert simpleJdbcInsert ;
	
	private boolean isTableNameSet = false;
	
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
	
	@Override
	public int insertApplicantDetails(ApplicantDetails applicantDetails){
		setTableName();
        Map parameters = new HashMap();  
        parameters.put("app_name", applicantDetails.getApplicantName());
   
        Number applicantId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return applicantId.intValue();
	}
	
	@Override
	public void createNewProcessInstance(ProcessInstanceDetails processInstance){
		jdbcTemplate.update(sqlQueries.createProcessInstanceQuery(), new Object[]{processInstance.getApp_id(), processInstance.getTsk_id(), processInstance.getPrc_id(), new Date(), processInstance.getNext_task_id()});
	}
	
	private void setTableName(){
		if(!isTableNameSet){
			simpleJdbcInsert.setTableName("applicant");
			simpleJdbcInsert.usingGeneratedKeyColumns("app_id");
			isTableNameSet = true;
		}
	}
}
