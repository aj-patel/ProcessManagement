package com.tavant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tavant.domain.UserDetails;
import com.tavant.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService ;
 
	@RequestMapping(method = RequestMethod.GET)
	public String showAdminLoginPage(ModelMap model) {
 
		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "admin";
 
	}
 
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String userCheck(ModelMap model, HttpServletRequest request) {
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		if("ajay".equalsIgnoreCase(name)&&"ajay".equalsIgnoreCase(pwd)){
			model.addAttribute("message", "Successfully logged in.");
			
		}else{
			model.addAttribute("message", "Username or password is wrong.");
		}
		return "adminHome";
	}
	
	@RequestMapping(value="/addUsers", method = RequestMethod.POST)
	public String addUsers(ModelMap model, HttpServletRequest request) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId("userId1");
		userDetails.setPassword(request.getParameter("password"));
		userDetails.setUserName(request.getParameter("userName"));
		userDetails.setRoleId(request.getParameter("role"));
		userService.addUserSerive(userDetails);
		return "adminHome";
	}
}