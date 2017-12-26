package com.student.app.restcontroller;

import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.dto.Student;
import com.student.app.service.StudentService;

@RestController
@RequestMapping("/rest")
public class StudentDataRestController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;
	HttpSession httpSession;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
    
	@RequestMapping(value = "/student{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
		logger.info("getStudents() entered");
		Student student=studentService.getStudentById(id);
		 if (student==null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
		 return new ResponseEntity<Student>(student, HttpStatus.OK);
	}


	@RequestMapping(value = "/student", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Student>> listAllStudents() {
		logger.info("listAllStudents() entered");
		List<Student> students=studentService.getAllStudents();
	    if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

}

