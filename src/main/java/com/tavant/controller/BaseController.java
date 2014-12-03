package com.tavant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tavant.exception.ResourceNotFoundException;

@Controller
public class BaseController {
	
	@ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException() {
        return "notfound";
    }

}
