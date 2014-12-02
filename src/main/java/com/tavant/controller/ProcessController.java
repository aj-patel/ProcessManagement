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
import com.tavant.service.ProcessInstanceService;
import com.tavant.service.ProcessService;
import com.tavant.service.TaskService;

@Controller
@RequestMapping("/process")
public class ProcessController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private ProcessInstanceService processInstanceService;
	
	@Autowired
	private ProcessService processService;
	
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
				model.addAttribute("taskDetails", taskDetails);
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
		Map<String, Object> myModel = new HashMap<String, Object>();
		if(null!=priId){
		boolean res = processService.updateProcessInstance(priId.toString(), status, comment);
		if (res) {
			myModel.put("info", "Task task completed successfully...");
		}
		}else{
			myModel.put("info", "No task to complete...");
		}
		return new ModelAndView("userHome", myModel);}
}
