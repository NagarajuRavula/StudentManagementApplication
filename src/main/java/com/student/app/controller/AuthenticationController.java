package com.student.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.student.app.service.StudentService;


@Controller
public class AuthenticationController {
	StudentService studentService;
    HttpSession httpSession;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/login")
	public ModelAndView homePage() {
		System.out.println("inside login--------------------");
		return new ModelAndView("login");
	}

	@RequestMapping("/authenticate")
	public ModelAndView Authenticate(@RequestParam("email") String email, @RequestParam("password") String password,HttpServletRequest request) {

		httpSession = request.getSession();
		if (email.equals("admin@gmail.com")) {
			httpSession.setAttribute("email", email);
			httpSession.setAttribute("role", "admin");
			return new ModelAndView("adminHome", "students", studentService.getAllStudents());
		} else {
			httpSession.setAttribute("email", email);
			httpSession.setAttribute("role", "student");
			return new ModelAndView("studentHome", "student", studentService.getStudentByEmail(email));
		}
	}
	
//	@RequestMapping("/logout")
//	public ModelAndView logout() {
//		httpSession.invalidate();
//		return new ModelAndView("login");
//	}
	
}
