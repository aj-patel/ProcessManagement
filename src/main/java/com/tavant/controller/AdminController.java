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
public class AdminController extends BaseController{
	
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
		if (!validateUserName(request.getParameter("userName"))) {
			model.addAttribute("message", "Enter user name..");
			return "createUser";
		}
		if (!validatePassword(request.getParameter("password"))) {
			model.addAttribute("message", "Enter password");
			return "createUser";
		}
		if (!validateRole(request.getParameter("role"))) {
			model.addAttribute("message", "Select role");
			return "createUser";
		}
		boolean isAdded = userService.addUserSerive(userDetails);
		if(isAdded){
			model.addAttribute("message", "New user " + userDetails.getUserName() + " created");
		}else{
			model.addAttribute("message", "User " + userDetails.getUserName() + " already exist");
			return "createUser";
		}
		
		return "adminHome";
	}
	
	@RequestMapping(value="/createTask", method = RequestMethod.POST)
	public String initiateProcess(ModelMap model, HttpServletRequest request) {
		ApplicantDetails applicantDetails = new ApplicantDetails();
		applicantDetails.setApplicantName(request.getParameter("appName"));
		int processId = Integer.parseInt(request.getParameter("processType"));
		ProcessInstanceDetails processInstanceDetails = new ProcessInstanceDetails(null, null, null, null, processId, null, null, null);
		processInstanceService.createProcessInstance(processInstanceDetails, applicantDetails);
		model.addAttribute("message", "New process for " + applicantDetails.getApplicantName() + " created");
		return "adminHome";
	}
	
	private boolean validateUserName(String username) {
		if (null != username && username.length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	private boolean validatePassword(String password) {
		if (null != password && password.length() > 0) {
			return true;
		} else {
			return false;
		}
	}

	private boolean validateRole(String role) {
		if (null != role && role.length() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
