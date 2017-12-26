package com.student.app.restcontroller;

import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.service.StudentService;

@RestController
@RequestMapping("/rest")
public class DeleteRestController {

	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		logger.info("delete() entered with id:" + id);
		int status = studentService.deleteById(id);
		if (status > 0) {
			logger.debug("delete() successfull");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			logger.debug("delete() failed");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
