package com.student.app.restcontroller;

import java.util.Properties;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.dto.Student;
import com.student.app.service.StudentService;

@RestController
@RequestMapping("/rest")
public class AuthenticationRestController {
	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/authenticate/{email}/{password}", method = RequestMethod.POST)
	public ResponseEntity<String> Authenticate(@PathVariable("email") String email, HttpServletResponse response,
			HttpServletRequest request,@PathVariable("password") String password) {
		logger.info("authenticate() entered with username:" + email);
		Properties properties = studentService.getProperties();
		HttpHeaders httpHeaders = new HttpHeaders();
		Student user = studentService.getStudentByEmail(email);
		if (user != null) {
			System.out.println("name:" + user.getName() + "role:" + user.getRole());
			httpHeaders.add("success", "USER EXISTS");
			if (user.getPassword().equals(password)) {
				Cookie cookies[] = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						cookie.setValue("");
						cookie.setPath("/");
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
				Cookie cookie1 = new Cookie("username", email);
				cookie1.setMaxAge(300);
				cookie1.setPath("/");
				response.addCookie(cookie1);
				Cookie cookie2 = new Cookie("password", password);
				cookie2.setMaxAge(300);
				cookie2.setPath("/");
				response.addCookie(cookie2);
				return new ResponseEntity<String>("Authorized", httpHeaders, HttpStatus.OK);
			} else {
				Cookie cookies[] = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						System.out.println("invalidating the cookie........."+cookie.getName());
						cookie.setValue("");
						cookie.setPath("/");
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
				return new ResponseEntity<String>(properties.getProperty("INVALID_PASSWORD"), httpHeaders,
						HttpStatus.UNAUTHORIZED);
			}

		}

		else {
			httpHeaders.add("error", "USER NOT EXISTS");
			logger.debug("authenticate() exited due to invalid username");
			Cookie cookies[] = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					System.out.println("invalidating the cookie........."+cookie.getName());
					cookie.setValue("");
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
			return new ResponseEntity<String>(properties.getProperty("INVALID_USERNAME"), httpHeaders,
					HttpStatus.NON_AUTHORITATIVE_INFORMATION);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<String> logout(HttpServletResponse response, HttpServletRequest request) {

		Cookie cookies[] = request.getCookies();
		if(cookies == null) {
			return new ResponseEntity<String>("	UN-AUTHORIZED",HttpStatus.UNAUTHORIZED);
		}
		else if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setValue("");
				cookie.setPath("/");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
