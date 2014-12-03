package com.tavant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tavant.dao.UserDao;
import com.tavant.domain.UserDetails;
import com.tavant.exception.ResourceNotFoundException;
import com.tavant.sql.SQLQueries;

public class UserDAOImpl implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SQLQueries sqlQueries;
	
	@Override
	public boolean addUser(UserDetails userDetails) throws ResourceNotFoundException{
		try{
			int res = jdbcTemplate.update(sqlQueries.getAddUserQuery(), new Object[]{userDetails.getUserName(),userDetails.getRoleId(),userDetails.getEncPassword(),userDetails.getSalt()});
			return res==1?true:false;
		} catch (Exception e) {
			throw new ResourceNotFoundException();
		}
	}

	@Override
	public UserDetails getUserDetails(String userName) throws ResourceNotFoundException{
		UserDetails userDetails;
		try{
			userDetails = (UserDetails) jdbcTemplate.queryForObject(sqlQueries.getUserDetailsQuery(), new Object[] { userName }, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			userDetails = new UserDetails(null, null, null, null, null, null);
		}catch (Exception e) {
			throw new ResourceNotFoundException();
		}
		return userDetails;
	}
	
	private class UserMapper implements RowMapper {
		public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserDetails userDetails = new UserDetails(rs.getString("usr_id"), rs.getString("usr_name"), rs.getString("rol_id"),null, rs.getBytes("usr_pass"), rs.getBytes("salt"));
			return userDetails;
		}
	}
	
}
