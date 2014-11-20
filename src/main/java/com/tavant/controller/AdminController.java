package com.tavant.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tavant.domain.TaskDetails;
import com.tavant.domain.UserDetails;
import com.tavant.service.TaskService;
import com.tavant.service.UserService;
import com.tavant.util.UniqueID;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private TaskService taskService;
 
	@RequestMapping(method = RequestMethod.GET)
	public String showAdminLoginPage(ModelMap model) {
 
		return "admin";
 
	}
 
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String userCheck(ModelMap model, HttpServletRequest request) {
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		boolean isValid = userService.validateUserLogin(name, pwd);
		if(isValid){
			model.addAttribute("message", "Successfully logged in.");
			return "adminHome";
		}else{
			model.addAttribute("message", "Username or password is wrong.");
		}
		return "admin";
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
	
	@RequestMapping(value="/createTask", method = RequestMethod.POST)
	public String createTask(ModelMap model, HttpServletRequest request) {
		TaskDetails taskDetails = new TaskDetails();
		taskDetails.setTaskName("task1");
		taskDetails.setTaskId(new Long(UniqueID.get()).toString());
		taskDetails.setStatus("new");
		taskDetails.setStep("1");
		taskService.addTask(taskDetails);
		return "adminHome";
	}
}