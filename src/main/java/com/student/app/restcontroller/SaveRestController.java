package com.student.app.restcontroller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.student.app.dto.Student;
import com.student.app.service.StudentService;

@RestController
@RequestMapping("/rest")
public class SaveRestController {

	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> saveStudent(@RequestBody Student student, UriComponentsBuilder ucBuilder,
			HttpServletRequest request) {
		logger.info("saveStudent() entered");
//		if (!request.isRequestedSessionIdValid()) {
//			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
//		}
		Student std = studentService.getStudentByEmail(student.getEmail());
		if (std != null) {
			logger.error("Unable to create. A User with name {} already exist");
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}

		studentService.saveStudent(student);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(student.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);

	}

}
