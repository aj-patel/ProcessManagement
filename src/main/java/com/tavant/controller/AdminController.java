package com.tavant.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tavant.domain.TaskDetails;
import com.tavant.domain.TaskProgressDetails;
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
 
	@RequestMapping(value="/showCreateUser",method = RequestMethod.GET)
	public String showCreateUserPage(ModelMap model) {
 
		return "createUser";
 
	}
 
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String userCheck(ModelMap model, HttpServletRequest request) {
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		UserDetails userDetails = userService.validateUserLogin(name, pwd);
		if(userDetails.getRoleId().equals("0")){
			model.addAttribute("message", "Successfully logged in.");
			return "adminHome";
		}else if(userDetails.getUserId() ==null){
			model.addAttribute("message", "Username or password is wrong.");
		}
		else{
			return "userHome";
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
		taskDetails.setTaskName(request.getParameter("taskName"));
		taskDetails.setTaskId(new Long(UniqueID.get()).toString());
		taskDetails.setStatus("new");
		taskDetails.setStep("1");
		taskService.addTask(taskDetails);
		return "adminHome";
	}
	
	@RequestMapping(value="/getTask", method = RequestMethod.GET)
	public ModelAndView getTask(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		TaskDetails taskDetails = taskService.getTask(request.getParameter("userId"));
		  Map<String, Object> myModel = new HashMap<String, Object>();
	        myModel.put("taskName", "task123");
	        myModel.put("step", "2");

	        return new ModelAndView("userHome", "model", myModel);
	}
	
	@RequestMapping(value="/completeTask", method = RequestMethod.POST)
	public String completeTask(ModelMap model, HttpServletRequest request) {
		String comment = request.getParameter("comment")!=null?request.getParameter("commet"):"";
		String tpId = request.getParameter("tpId")!=null?request.getParameter("tpId"):"";
		taskService.completeTask(comment, tpId);
		return "adminHome";
	}
	
	@RequestMapping(value="/getTaskProgress", method = RequestMethod.POST)
	public String getTaskProgress(ModelMap model, HttpServletRequest request) {
		String userId = request.getParameter("userId")!=null?request.getParameter("userId"):"";
		TaskProgressDetails taskProgressDetails = taskService.getTaskProgress(userId);
		return "adminHome";
	}
}