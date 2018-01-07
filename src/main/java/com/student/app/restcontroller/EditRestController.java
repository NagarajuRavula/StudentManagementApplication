package com.student.app.restcontroller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.dto.Student;
import com.student.app.service.StudentService;

@RestController
@RequestMapping("/rest")
public class EditRestController {

	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> edit(@PathVariable("id") int id, @RequestBody Student student,
			HttpServletRequest request) {
		logger.info("edit() entered with id:" + id);
//		if (!request.isRequestedSessionIdValid()) {
//			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
//		}
		Student std = studentService.getStudentById(id);
		if (std == null) {
			logger.error("Unable to update. User with id {} not found." + id);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (!std.getEmail().equals(student.getEmail())) {
			Student temp_std = studentService.getStudentByEmail(student.getEmail());
			if (temp_std != null) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}
		std.setAttendence(student.getAttendence());
		std.setClassrank(student.getClassrank());
		std.setEmail(student.getEmail());
		std.setFatherName(student.getFatherName());
		std.setGender(student.getGender());
		std.setMarks(student.getMarks());
		std.setMothername(student.getMothername());
		std.setName(student.getName());
		std.setPassword(student.getPassword());
		std.setPresentClass(student.getPresentClass());
		std.setRole(student.getRole());
		studentService.updateStudent(std);
		return new ResponseEntity<Student>(std, HttpStatus.OK);
	}

}
