package com.student.app.controller;

import java.util.Date;
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
import com.student.app.security.TokenHandler;
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
	public String login(ModelMap model) {
		logger.info("login() entered");
		return "login";
	}

	@RequestMapping(value = "/authenticate")
	public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request, ModelMap model,HttpServletResponse response) {
		logger.info("authenticate() entered with username:" + email);
		Properties properties = studentService.getProperties();
		Student user = studentService.getStudentByEmail(email);
		if (user != null) {
//			System.out.println("name:" + user.getName() + "role:" + user.getRole());
//			httpSession = request.getSession();
//			if (user.getRole().equals("admin")) {
//				if (user.getPassword().equals(password)) {
//					httpSession.setAttribute("email", email);
//					httpSession.setAttribute("role", "admin");
//					model.addAttribute("admin", studentService.getStudentByEmail(email));
//					return "adminHome";
//				} else {
//					logger.debug("authenticate() failed due to invalid password");
//					model.addAttribute("errorMessage", properties.getProperty("INVALID_PASSWORD"));
//					return "login";
//				}
//			} else {
//				if (user.getPassword().equals(password)) {
//					httpSession.setAttribute("email", email);
//					httpSession.setAttribute("role", "student");
//					model.addAttribute("student", studentService.getStudentByEmail(email));
//					return "studentHome";
//				} else {
//					logger.debug("authenticate() failed due to invalid password");
//					model.addAttribute("errorMessage", properties.getProperty("INVALID_PASSWORD"));
//					return "login";
//				}
//			}
			
			httpSession = request.getSession();

			if(user.getPassword().equals(password)) {
				httpSession.setAttribute("email", email);
				httpSession.setAttribute("role", user.getRole());
				long nowMillis = System.currentTimeMillis();
				Date now = new Date(nowMillis);
				// System.out.println("Token Id: "+user.getId()+""+now.getTime());
				String tokenId = user.getId() + "" + now.getTime();
				String jwt = TokenHandler.createToken(user.getEmail(), user.getRole(), tokenId);
				Cookie cookies[] = request.getCookies();
				if (cookies != null) {
					System.out.println("deleting cookies----------------->");
					for (Cookie cookie : cookies) {
						cookie.setValue("");
						cookie.setPath("/");
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
				System.out.println("setting cookies-------------------->");
				Cookie cookie1 = new Cookie("jwt", jwt);
				cookie1.setMaxAge(1800);
				cookie1.setPath("/");
				response.addCookie(cookie1);
				if(user.getRole().equals("student")) {
					model.addAttribute("student", studentService.getStudentByEmail(email));
					return "studentHome";
				}
				else {
					model.addAttribute("admin", studentService.getStudentByEmail(email));
					return "adminHome";
				}
			}
			else {
				logger.debug("authenticate() failed due to invalid password");
				model.addAttribute("errorMessage", properties.getProperty("INVALID_PASSWORD"));
				return "login";

			}
		}

		else {
			logger.debug("authenticate() exited due to invalid username");
			model.addAttribute("errorMessage", properties.getProperty("INVALID_USERNAME"));
			return "login";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET, produces = "application/json")
	public String logout(ModelMap model,HttpServletRequest request,HttpServletResponse response) {
		logger.info("logout() entered");
		httpSession.invalidate();
		return "login";
	}

}
