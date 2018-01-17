package com.student.app.restcontroller;

import java.util.Date;
import java.util.Properties;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
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
	public ResponseEntity<Object> authenticate(HttpServletRequest request, @PathVariable("email") String email,
			HttpServletResponse response, @PathVariable("password") String password) {
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
				long nowMillis = System.currentTimeMillis();
				Date now = new Date(nowMillis);
				// System.out.println("Token Id: "+user.getId()+""+now.getTime());
				String tokenId = user.getId() + "" + now.getTime();
				String token = TokenHandler.createToken(email, user.getRole(), tokenId);
				JsonObject jsonObject = Json.createObjectBuilder().add("Authorization", token).build();
				return new ResponseEntity<Object>(jsonObject, httpHeaders, HttpStatus.OK);
			} else {
				httpHeaders.add("failure", "Authentication failed");
				return new ResponseEntity<Object>(properties.getProperty("INVALID_PASSWORD"), httpHeaders,
						HttpStatus.FORBIDDEN);
			}

		}

		else {
			httpHeaders.add("message", "USER NOT EXISTS");
			logger.debug("authenticate() exited due to invalid username");
			return new ResponseEntity<Object>(properties.getProperty("INVALID_USERNAME"), httpHeaders,
					HttpStatus.FORBIDDEN);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response,@RequestHeader(value="Authorization") String authorization) {
		HttpSession hs = request.getSession(false);
		if (hs != null) {
			System.out.println("session is not null");
			hs.invalidate();
			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("	UN-AUTHORIZED", HttpStatus.UNAUTHORIZED);
		}

	}

}
