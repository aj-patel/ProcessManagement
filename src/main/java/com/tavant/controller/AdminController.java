package com.tavant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {
 
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
}