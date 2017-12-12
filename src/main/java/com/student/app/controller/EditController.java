package com.student.app.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.student.app.dto.Student;
import com.student.app.service.StudentService;

@Controller
public class EditController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/editStudentDetails")
	public ModelAndView editStudentDetails(@PathParam("email") String email) {
		return new ModelAndView("editStudentDetails", "student", studentService.getStudentByEmail(email));
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("originalEmail") String originalEail,
			@RequestParam("fatherName") String fatherName, @RequestParam("motherName") String motherName,
			@RequestParam("gender") String gender, @RequestParam("presentClass") int presentClass,
			@RequestParam("marks") double marks, @RequestParam("attendence") double attendence,
			@RequestParam("classrank") int classrank, @RequestParam("password") String password) {

		System.out.println("name before:-----"+name);
		Student student=studentService.updateStudent(attendence, classrank, email, fatherName, gender, id, marks, motherName, name, password, presentClass);
		System.out.println("name after:-----"+student.getName());
		return new ModelAndView("studentHome","student",student);
	}
}
