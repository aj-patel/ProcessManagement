package com.tavant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tavant.domain.ProcessInstanceDetails;
import com.tavant.domain.TaskDetails;
import com.tavant.domain.UserDetails;
import com.tavant.service.ProcessInstanceService;
import com.tavant.service.TaskService;
import com.tavant.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ProcessInstanceService processInstanceService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showAdminLoginPage(ModelMap model) {
		return "admin";
	}
	
	@RequestMapping(value="/home", method = RequestMethod.POST)
	public String userCheck(ModelMap model, HttpServletRequest request) {
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		if (name.equals("") || pwd.equals("")) {
			model.addAttribute("error", "Enter username and password");
			return "admin";
		} else{
			UserDetails userDetails = userService.validateUserLogin(name, pwd);
			if(null!=userDetails.getRoleId() && userDetails.getRoleId().equals("0")){
				return "adminHome";
			}else if(null!=userDetails && userDetails.getUserId() ==null){
				model.addAttribute("error", "Username or password is wrong.");
				return "admin";
			}else{
				int userId = Integer.parseInt(userDetails.getUserId());
				ProcessInstanceDetails processInstanceDetails = processInstanceService.isUserFree(userId);
				boolean showGetNext = processInstanceDetails != null && processInstanceDetails.getUsr_id() != null && processInstanceDetails.getTsk_id() !=0;
				model.put("showGetNext", showGetNext);
				if(processInstanceDetails.getTsk_id() != null && processInstanceDetails.getTsk_id() !=0){
					TaskDetails taskDetails = taskService.getTaskDetails(processInstanceDetails.getTsk_id());
					model.addAttribute("taskDetails", taskDetails);
					
				}
				model.addAttribute("userId", userDetails.getUserId());
				request.getSession().setAttribute("roleId", userDetails.getRoleId());
				request.getSession().setAttribute("userId", userDetails.getUserId());
				return "userHome";
			}
		}
	}
}
