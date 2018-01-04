package com.student.app.restcontroller;

import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.dto.Student;
import com.student.app.security.TokenHandler;
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
			HttpServletRequest request, @PathVariable("password") String password) {
		logger.info("authenticate() entered with username:" + email);
		Properties properties = studentService.getProperties();
		HttpHeaders httpHeaders = new HttpHeaders();
		Student user = studentService.getStudentByEmail(email);
		HttpSession existingSession = request.getSession(false);
		if (existingSession != null)
			existingSession.invalidate();
		if (user != null) {
			System.out.println("name:" + user.getName() + "role:" + user.getRole());
			httpHeaders.add("message", "USER EXISTS");
			if (user.getPassword().equals(password)) {
				httpHeaders.add("success", "Authentication success");
			//	HttpSession hs = request.getSession();
			//	hs.setMaxInactiveInterval(300); // 5 mins interval inactive time
				
				TokenHandler tokenHandler = new TokenHandler();
				
				String token= tokenHandler.createToken(email,user.getRole());
				return new ResponseEntity<String>(token, httpHeaders, HttpStatus.OK);
			} else {
				httpHeaders.add("failure", "Authentication failed");
				return new ResponseEntity<String>(properties.getProperty("INVALID_PASSWORD"), httpHeaders,
						HttpStatus.FORBIDDEN);
			}

		}

		else {
			httpHeaders.add("message", "USER NOT EXISTS");
			logger.debug("authenticate() exited due to invalid username");
			return new ResponseEntity<String>(properties.getProperty("INVALID_USERNAME"), httpHeaders,
					HttpStatus.FORBIDDEN);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<String> logout(HttpServletResponse response, HttpServletRequest request) {
		HttpSession hs = request.getSession(false);
		if (hs != null) {
			System.out.println("session is not null");
			hs.invalidate();
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("	UN-AUTHORIZED", HttpStatus.UNAUTHORIZED);
		}
		
//		long nowMillis = System.currentTimeMillis();
//		Date now = new Date(nowMillis);
		

	}
}
