package com.tavant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tavant.dao.ProcessDao;
import com.tavant.domain.ProcessInstanceDetails;
import com.tavant.sql.SQLQueries;

public class ProcessDAOImpl implements ProcessDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SQLQueries sqlQueries;
	
	public boolean updateProcessInstance(String prcId,String status, String comment){
		ProcessInstanceDetails processInstanceDetails=null;
		try{
			processInstanceDetails = (ProcessInstanceDetails) jdbcTemplate.queryForObject(sqlQueries.getProcessInstanceQuery(), new Object[] { prcId }, new ProcessInstanceMapper());
		} catch (EmptyResultDataAccessException e) {
		}
		int res = 0;
		if(null!=processInstanceDetails){
			res = jdbcTemplate.update(sqlQueries.getTaskCompleteQuery(), new Object[]{processInstanceDetails.getTsk_id(),processInstanceDetails.getApp_id(),processInstanceDetails.getUsr_id(),status,comment,processInstanceDetails.getTsk_start_dt(),new Date(),processInstanceDetails.getPrc_id() });
		}
		
	return res==1?true:false;	
	}
	
	private class ProcessInstanceMapper implements RowMapper {
		public ProcessInstanceDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProcessInstanceDetails processInstanceDetails = new ProcessInstanceDetails(rs.getInt("pri_id"),rs.getInt("app_id"),rs.getInt("tsk_id"),rs.getInt("usr_id"),rs.getInt("prc_id"),rs.getDate("tsk_start_dt"), rs.getDate("prc_start_dt"));
			return processInstanceDetails;
		}
	}

}
