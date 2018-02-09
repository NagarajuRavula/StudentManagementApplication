package com.student.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class RouteController {


	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String adminHome(HttpServletRequest request,HttpServletResponse response) {
		return "adminHome";
	}
	
	@RequestMapping(value = "/studentReport", method = RequestMethod.GET)
	public String studentReport(HttpServletRequest request,HttpServletResponse response) {
		return "studentReport";
	}
	
	@RequestMapping(value = "/studentIssues", method = RequestMethod.GET)
	public String studentIssues(HttpServletRequest request,HttpServletResponse response) {
		return "studentIssues";
	}
	
	@RequestMapping(value = "/addPost", method = RequestMethod.GET)
	public String addPost(HttpServletRequest request,HttpServletResponse response) {
		return "postNews";
	}
	
	
}
