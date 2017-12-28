package com.student.app.restcontroller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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
public class StudentDataRestController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;
	HttpSession httpSession;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
    
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<Student> getStudent(@PathVariable("id") int id,HttpServletRequest request) {
		logger.info("getStudents() entered");
		Cookie cookie[] = request.getCookies();
		if(cookie==null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		Student student=studentService.getStudentById(id);
		 if (student==null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
		 return new ResponseEntity<Student>(student, HttpStatus.OK);
	}


	@RequestMapping(value = "/student", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Student>> listAllStudents(HttpServletRequest request){
		logger.info("listAllStudents() entered");
		Cookie cookie[] = request.getCookies();
		if(cookie==null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		List<Student> students=studentService.getAllStudents();
	    if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

}

