package com.student.app.controller;

import java.util.Properties;

import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.app.service.StudentService;

@Controller
public class DeleteController {

	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/delete")
	public String delete(@PathParam("id") int id, ModelMap model) {
		logger.info("delete() entered with id:" + id);
		Properties properties = studentService.getProperties();
		int status = studentService.deleteById(id);
		if (status > 0) {
			model.addAttribute("errorMessage", properties.getProperty("DELETE_SUCCESS"));
			logger.debug("delete() successfull");
		} else {
			model.addAttribute("errorMessage", properties.getProperty("DATABASE_ERROR"));
			logger.debug("delete() failed");
		}
		model.addAttribute("students", studentService.getAllStudents());
		return "adminHome";
	}
}
