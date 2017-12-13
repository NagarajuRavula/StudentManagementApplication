package com.student.app.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.student.app.service.StudentService;

@Controller
public class DeleteController {

	StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping("/delete")
	public String delete(@PathParam("id") int id,ModelMap model) {
		Integer studentId =(Integer)id;
		studentService.deleteStudent(studentId);
		model.addAttribute("students", studentService.getAllStudents());
		return "adminHome";
	}
}
