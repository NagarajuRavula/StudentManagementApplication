package com.student.app.controller;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.app.service.StudentService;

@Controller
@RequestMapping("/")
public class DeleteController {

	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/delete",method = RequestMethod.DELETE)
	public String delete(@PathParam("id") int id, ModelMap model,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("delete enteres--------------(:");
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
