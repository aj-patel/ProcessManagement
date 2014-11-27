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

import com.tavant.domain.ApplicantDetails;
import com.tavant.domain.ProcessInstanceDetails;
import com.tavant.domain.TaskDetails;
import com.tavant.domain.TaskProgressDetails;
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
 
	@RequestMapping(value="/login", method = RequestMethod.POST)
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
				model.put("showGetNext", processInstanceService.isUserFree(userId));
				model.addAttribute("userId", userDetails.getUserId());
				request.getSession().setAttribute("roleId", userDetails.getRoleId());
				request.getSession().setAttribute("userId", userDetails.getUserId());
				return "userHome";
			}
		}
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
	
	@RequestMapping(value="/getTask", method = RequestMethod.GET)
	public ModelAndView getTask(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		String roleId = (String)request.getSession().getAttribute("roleId");
		String userId = (String)request.getSession().getAttribute("userId");
		int userIdInt=0;
		Map nextTaskIdMap =null;
		if(roleId !=null){
			int roleIdInt= Integer.parseInt(roleId);
			nextTaskIdMap = processInstanceService.getNextTask(roleIdInt);
		}
		if(userId !=null){
			userIdInt= Integer.parseInt(userId);
		}
		if(nextTaskIdMap !=null){
			Integer nextTaskId =(Integer) nextTaskIdMap.get("tsk_id");
			Integer processId = (Integer) nextTaskIdMap.get("pri_id");
			request.getSession().setAttribute("priId",processId );
			TaskDetails taskDetails = taskService.getTaskDetails(nextTaskId);
			
			
			if(null!=taskDetails){
				model.put("taskName", taskDetails.getTsk_name());
				model.put("taskDescription",taskDetails.getTsk_desc());
				processInstanceService.updateProcessInstanceWithUserId(processId, userIdInt);
		        return new ModelAndView("userHome");
			}
		}
		else{
			model.put("info", "No task available for user..");
		}
		return new ModelAndView("userHome");
	}
	
	@RequestMapping(value="/completeTask", method = RequestMethod.POST)
	public ModelAndView completeTask(ModelMap model, HttpServletRequest request) {
		String comment = request.getParameter("comment") != null ? request.getParameter("comment") : "";
		String status = request.getParameter("status") != null ? request.getParameter("status") : "";
		Integer priId = (Integer)request.getSession().getAttribute("priId");
		boolean res = processService.updateProcessInstance(priId.toString(), status, comment);

		Map<String, Object> myModel = new HashMap<String, Object>();
		if (res) {
			myModel.put("info", "Task task completed successfully...");
		}
		return new ModelAndView("userHome", myModel);
	}
	
	@RequestMapping(value="/getTaskProgress", method = RequestMethod.POST)
	public String getTaskProgress(ModelMap model, HttpServletRequest request) {
		String userId = request.getParameter("userId")!=null?request.getParameter("userId"):"";
		TaskProgressDetails taskProgressDetails = taskService.getTaskProgress(userId);
		return "adminHome";
	}
}
