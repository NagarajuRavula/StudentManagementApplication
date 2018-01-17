package com.student.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.app.service.StudentService;

@Controller
public class DeleteControllerAjax {
	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("id") int id, HttpServletRequest request,HttpServletResponse response) {
		logger.info("delete() entered with id:" + id);
		HttpHeaders httpHeaders = new HttpHeaders();
		int status = studentService.deleteById(id);
		if (status > 0) {
			logger.debug("delete() successfull ----;;;;''''");
			httpHeaders.add("success", "deleted");
			return new ResponseEntity<String>("DELETE SUCCESSFUL", httpHeaders, HttpStatus.OK);
		} else {
			logger.debug("delete() failed");
			httpHeaders.add("error", "id not found");
			return new ResponseEntity<String>("ID NOT FOUND", httpHeaders, HttpStatus.NOT_FOUND);
		}

	}
}
