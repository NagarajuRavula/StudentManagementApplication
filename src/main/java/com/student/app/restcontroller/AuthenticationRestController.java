package com.student.app.restcontroller;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.dto.Student;
import com.student.app.service.StudentService;

@RestController
@RequestMapping("/rest")
public class AuthenticationRestController {
	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;
	HttpSession httpSession;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

    
	@RequestMapping(value = "/authenticate")
	public ResponseEntity<String> Authenticate(@PathVariable("email") String email, @PathVariable("password") String password,
			HttpServletRequest request, ModelMap model) {
		logger.info("authenticate() entered with username:" + email);
		Properties properties = studentService.getProperties();
		Student user = studentService.getStudentByEmail(email);
		if (user != null) {
			System.out.println("name:" + user.getName() + "role:" + user.getRole());
			httpSession = request.getSession();
//			if (user.getRole().equals("admin")) {
//				if (user.getPassword().equals(password)) {
//					httpSession.setAttribute("email", email);
//					httpSession.setAttribute("role", "admin");
//					model.addAttribute("students", studentService.getAllStudents());
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
			if(user.getPassword().equals(password)) {
				
			}
			else {
				return new ResponseEntity<String>(properties.getProperty("INVALID_PASSWORD"),HttpStatus.UNAUTHORIZED);
			}
			
		}

		else {
			logger.debug("authenticate() exited due to invalid username");
			//model.addAttribute("errorMessage", properties.getProperty("INVALID_USERNAME"));
			//return "login";
			return new ResponseEntity<String>(properties.getProperty("INVALID_USERNAME"),HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		}
	}
	
}
