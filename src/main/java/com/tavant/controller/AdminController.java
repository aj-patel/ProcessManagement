package com.tavant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tavant.domain.ApplicantDetails;
import com.tavant.domain.ProcessInstanceDetails;
import com.tavant.domain.UserDetails;
import com.tavant.service.ProcessInstanceService;
import com.tavant.service.ProcessService;
import com.tavant.service.TaskService;
import com.tavant.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ProcessInstanceService processInstanceService;
 
	@Autowired
	private ProcessService processService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showAdminLoginPage(ModelMap model) {
		return "admin";
	}
 
	@RequestMapping(value="/showCreateUser",method = RequestMethod.GET)
	public String showCreateUserPage(ModelMap model) {
		return "createUser";
	}
	
	@RequestMapping(value="/addUsers", method = RequestMethod.POST)
	public String addUsers(ModelMap model, HttpServletRequest request) {
		UserDetails userDetails = new UserDetails();
		userDetails.setPassword(request.getParameter("password"));
		userDetails.setUserName(request.getParameter("userName"));
		userDetails.setRoleId(request.getParameter("role"));
		userService.addUserSerive(userDetails);
		model.addAttribute("message", "New user " + userDetails.getUserName() + " created");
		return "adminHome";
	}
	
	@RequestMapping(value="/createTask", method = RequestMethod.POST)
	public String initiateProcess(ModelMap model, HttpServletRequest request) {
		ApplicantDetails applicantDetails = new ApplicantDetails();
		applicantDetails.setApplicantName(request.getParameter("appName"));
		int processId = Integer.parseInt(request.getParameter("processType"));
		ProcessInstanceDetails processInstanceDetails = new ProcessInstanceDetails(null, null, null, null, processId, null, null, null);
		processInstanceService.createProcessInstance(processInstanceDetails, applicantDetails);
		return "adminHome";
	}
}
