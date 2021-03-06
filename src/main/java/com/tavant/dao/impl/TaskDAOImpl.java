package com.tavant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tavant.dao.TaskDao;
import com.tavant.domain.TaskDetails;
import com.tavant.domain.UserDetails;
import com.tavant.exception.ResourceNotFoundException;
import com.tavant.sql.SQLQueries;

public class TaskDAOImpl implements TaskDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SQLQueries sqlQueries;
	
	
	@Override
	public boolean completeStep(String comment, String tId, int step) throws ResourceNotFoundException{
		try{
			int res = jdbcTemplate.update(sqlQueries.getCompleteTaskQuery(),new Object[]{comment,new Date(),tId});
			if(res==1){
				++step;
				int r = jdbcTemplate.update(sqlQueries.updateTaskQuery(),new Object[]{step,tId});
				if(r==1){
					return true;
				}
			}
		}catch(Exception e){
			throw new ResourceNotFoundException();
		}
		return false;
	}
	
	
	@Override
	public TaskDetails getTaskDetails(int taskId) throws ResourceNotFoundException{
		// TODO Auto-generated method stub
		TaskDetails taskDetails;
		try{
			taskDetails = (TaskDetails) jdbcTemplate.queryForObject(sqlQueries.getTaskDetailsByTaskId(), new Object[] { taskId }, new TaskMapper());
		} catch (EmptyResultDataAccessException e) {
			taskDetails = new TaskDetails();
		}catch(Exception e){
			throw new ResourceNotFoundException();
		}
		return taskDetails;
	}
	
	@Override
	public TaskDetails getFirstTask(int processId) throws ResourceNotFoundException{
		try{
			List<Map> rows = jdbcTemplate.queryForList(sqlQueries.getFirstTaskQuery(), new Object[]{processId});
			if(null!=rows && rows.size()>0){
				TaskDetails taskdetail = new TaskDetails();
				for(Map map : rows){
					taskdetail.setTsk_id((int)map.get("tsk_id"));
					taskdetail.setNext_task_id((int)map.get("next_task_id"));
					return taskdetail;
				}
			}
		}catch(Exception e){
			throw new ResourceNotFoundException();
		}
		return null;
	}
	
	private class TaskMapper implements RowMapper {
		public TaskDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			TaskDetails taskDetails = new TaskDetails(rs.getInt("tsk_id"),rs.getInt("prc_id"),rs.getString("tsk_name"),rs.getString("tsk_desc"),rs.getInt("next_task_id"),rs.getInt("srt_and_end"));
			return taskDetails;
		}
	}
}
