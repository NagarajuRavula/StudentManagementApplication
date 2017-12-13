package com.student.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.app.service.StudentService;

@Controller
public class EditController {

	StudentService studentService;
	HttpSession httpSession;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/editStudentDetails")
	public String editStudentDetails(@PathParam("email") String email, ModelMap model) {
		model.addAttribute("student", studentService.getStudentByEmail(email));
		return "editStudentDetails";
	}

	@RequestMapping("/edit")
	public String edit(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("originalEmail") String originalEail,
			@RequestParam("fatherName") String fatherName, @RequestParam("motherName") String motherName,
			@RequestParam("gender") String gender, @RequestParam("presentClass") int presentClass,
			@RequestParam("marks") double marks, @RequestParam("attendence") double attendence,
			@RequestParam("classrank") int classrank, @RequestParam("password") String password,
			HttpServletRequest request, ModelMap model) {
		studentService.updateStudent(attendence, classrank, email, fatherName, gender, id, marks, motherName, name,
				password, presentClass);
		httpSession = request.getSession(false);
		if (httpSession.getAttribute("role").equals("admin")) {

			model.addAttribute("students", studentService.getAllStudents());
			return "adminHome";
		} else {
			model.addAttribute("student", studentService.getStudentByEmail(email));
			return "studentHome";

		}
	}

	@RequestMapping("/editGoBack")
	public String editGoBack(HttpServletRequest request, ModelMap model) {
		httpSession = request.getSession(false);
		if (httpSession.getAttribute("role").equals("admin")) {
			model.addAttribute("students", studentService.getAllStudents());
			return "adminHome";
		} else {
			String email = (String) httpSession.getAttribute("email");
			model.addAttribute("student", studentService.getStudentByEmail(email));
			return "studentHome";
		}

	}

}
