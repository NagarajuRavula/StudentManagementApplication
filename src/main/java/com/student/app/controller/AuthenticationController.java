package com.student.app.controller;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.app.dto.Student;
import com.student.app.service.StudentService;

@Controller
public class AuthenticationController {
	StudentService studentService;
	HttpSession httpSession;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/login")
	public String homePage(ModelMap model) {
		return "login";
	}

	@RequestMapping("/authenticate")
	public String Authenticate(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request, ModelMap model) {
		Properties properties = studentService.getProperties();
		Student user = studentService.getStudentByEmail(email);
		if (user != null) {
			httpSession = request.getSession();
			if (user.getRole().equals("admin")) {
				if (user.getPassword().equals(password)) {
					httpSession.setAttribute("email", email);
					httpSession.setAttribute("role", "admin");
					model.addAttribute("students", studentService.getAllStudents());
					return "adminHome";
				} else {
					model.addAttribute("errorMessage",properties.getProperty("INVALID_PASSWORD"));
					return "login";
				}
			} else {
				if (user.getPassword().equals(password)) {
					httpSession.setAttribute("email", email);
					httpSession.setAttribute("role", "student");
					model.addAttribute("student", studentService.getStudentByEmail(email));
					return "studentHome";
				} else {
					model.addAttribute("errorMessage",properties.getProperty("INVALID_PASSWORD"));
					return "login";
				}
			}
		}

		else {
			model.addAttribute("errorMessage",properties.getProperty("INVALID_USERNAME"));
			return "login";
		}
	}

	@RequestMapping("/logout")
	public String logout(ModelMap model) {
		httpSession.invalidate();
		return "login";
	}

}
