package com.student.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.student.app.service.StudentService;

@Controller
public class AuthenticationController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping("/")
	public ModelAndView homePage() {
		return new ModelAndView("login");
	}

	@RequestMapping("/authenticate")
	public ModelAndView Authenticate(@RequestParam("email") String email, @RequestParam("password") String password) {

		if (email.equals("admin@gmail.com")) {
			return new ModelAndView("adminHome","students",studentService.getAllStudents());
		}
		else {
			return new ModelAndView("studentHome","student",studentService.getStudentByEmail(email));
		}
	}
}
