package com.student.app.controller;

import java.util.Properties;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.app.dto.Student;
import com.student.app.service.StudentService;

@Controller
@RequestMapping("/")
public class AuthenticationController {

	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;
	HttpSession httpSession;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/login")
	public String homePage(ModelMap model) {
		logger.info("homePage() entered");
		return "login";
	}

	@RequestMapping(value = "/authenticate")
	public String Authenticate(@RequestParam("email") String email,HttpServletResponse response, @RequestParam("password") String password,
			HttpServletRequest request, ModelMap model) {
		logger.info("authenticate() entered with username:" + email);
		Properties properties = studentService.getProperties();
		Student user = studentService.getStudentByEmail(email);
		if (user != null) {
			System.out.println("name:" + user.getName() + "role:" + user.getRole());
			httpSession = request.getSession();
			if (user.getRole().equals("admin")) {
				if (user.getPassword().equals(password)) {
					httpSession.setAttribute("email", email);
					httpSession.setAttribute("role", "admin");
					response.addCookie(new Cookie("username", email));
					model.addAttribute("students", studentService.getAllStudents());
					return "adminHome";
				} else {
					logger.debug("authenticate() failed due to invalid password");
					model.addAttribute("errorMessage", properties.getProperty("INVALID_PASSWORD"));
					return "login";
				}
			} else {
				if (user.getPassword().equals(password)) {
					httpSession.setAttribute("email", email);
					httpSession.setAttribute("role", "student");
					model.addAttribute("student", studentService.getStudentByEmail(email));
					return "studentHome";
				} else {
					logger.debug("authenticate() failed due to invalid password");
					model.addAttribute("errorMessage", properties.getProperty("INVALID_PASSWORD"));
					return "login";
				}
			}
		}

		else {
			logger.debug("authenticate() exited due to invalid username");
			model.addAttribute("errorMessage", properties.getProperty("INVALID_USERNAME"));
			return "login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json")
	public String logout(ModelMap model) {
		logger.info("logout() entered");
		httpSession.invalidate();
		return "login";
	}

}
