package com.student.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class RouteController {

    //set of admin role routes
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
	
	
	
	
	//set of student role routes
	@RequestMapping(value = "/studentHome", method = RequestMethod.GET)
	public String studentHome(HttpServletRequest request,HttpServletResponse response) {
		return "studentHome";
	}
	
	@RequestMapping(value = "/addIssue", method = RequestMethod.GET)
	public String addIssue(HttpServletRequest request,HttpServletResponse response) {
		return "postIssues";
	}

	@RequestMapping(value = "/adminNews", method = RequestMethod.GET)
	public String adminNews(HttpServletRequest request,HttpServletResponse response) {
		return "adminNews";
	}


	
	
	
}
