package com.tavant.service.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;

import com.tavant.dao.UserDao;
import com.tavant.domain.UserDetails;
import com.tavant.service.UserService;
import com.tavant.util.PasswordEncryptionService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncryptionService passwordEncryptionService;
	
	public boolean addUserSerive(final UserDetails userDetails) {

		UserDetails uDetails = userDao.getUserDetails(userDetails.getUserName());
		if(null!= uDetails.getUserName()){
			return false;
		}
		
		 encryptPassword(userDetails);
		 
		return  userDao.addUser(userDetails);
		
	}
	
	private void encryptPassword(final UserDetails userDetails) {
		byte[] salt;
		 byte[] encryptedpass;
		try {
			salt = passwordEncryptionService.generateSalt();
			
			try {
				encryptedpass = passwordEncryptionService.getEncryptedPassword(userDetails.getPassword().toString(), salt);
				userDetails.setEncPassword(encryptedpass);
				userDetails.setSalt(salt);
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	public UserDetails validateUserLogin(String userName, String password) {
		boolean isValid =false;
		UserDetails userDetails = userDao.getUserDetails(userName);
		
		if(null!=userDetails){
			try {
				if(null!=userDetails.getEncPassword() && null!=userDetails.getSalt()){
					 isValid = passwordEncryptionService.authenticate(password, userDetails.getEncPassword(), userDetails.getSalt());
				}
				
				 if(!isValid){
					 return new UserDetails(null, null, null, null, null, null);
				 }
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				e.printStackTrace();
			}
		}
		return userDetails;
	}
}
