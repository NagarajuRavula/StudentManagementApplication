package com.student.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.dto.Student;
import com.student.app.service.StudentService;
@RestController
public class StudentDataController {

	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	@RequestMapping(value = "/student", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Student>> listAllStudents(HttpServletRequest request) {
		logger.info("listAllStudents() entered");
		List<Student> students = studentService.getAllStudents();
		if (students.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
}
