package com.tavant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.tavant.dao.UserDao;
import com.tavant.domain.UserDetails;
import com.tavant.sql.SQLQueries;

public class UserDAOImpl implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SQLQueries sqlQueries;
	
	public boolean addUser(UserDetails userDetails) {
		
		jdbcTemplate.update(sqlQueries.getAddUserQuery(), new Object[]{userDetails.getUserName(),userDetails.getRoleId(),userDetails.getPassword()});
		
		return false;
	}

	public UserDetails getUserDetails(String userName, String password) {
		UserDetails userDetails;
		try{
			userDetails = (UserDetails) jdbcTemplate.queryForObject(sqlQueries.getUserDetailsQuery(), new Object[] { userName, password }, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			userDetails = new UserDetails(null, null, null, null);
		}
		return userDetails;
	}
	
	private class UserMapper implements RowMapper {
		public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserDetails userDetails = new UserDetails(rs.getString("uid"), rs.getString("uname"), rs.getString("rid"), rs.getString("password"));
			return userDetails;
		}
	}
	
}
