package com.student.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.app.service.StudentService;

@Controller
public class SaveController {

	StudentService studentService;
	HttpSession httpSession;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping("/addStudent")
	public String addStudent(ModelMap model) {

		return "studentPersonalDetails";
	}

	@RequestMapping("/studentPersonalDetails")
	public String studentPersonalDetails(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("motherName") String motherName, @RequestParam("fatherName") String fatherName,
			@RequestParam("gender") String gender, HttpServletRequest request, ModelMap model) {

		httpSession = request.getSession(false);
		httpSession.setAttribute("sname", name);
		httpSession.setAttribute("semail", email);
		httpSession.setAttribute("smotherName", motherName);
		httpSession.setAttribute("sfatherName", fatherName);
		httpSession.setAttribute("sgender", gender);
		return "studentEducationDetails";
	}

	@RequestMapping("/saveStudent")
	public String saveStudent(@RequestParam("presentclass") int presentClass, @RequestParam("marks") double marks,
			@RequestParam("attendence") double attendence, @RequestParam("classrank") int classRank,
			@RequestParam("password") String password, ModelMap model) {
		studentService.saveStudent(attendence, classRank, (String) httpSession.getAttribute("semail"),
				(String) httpSession.getAttribute("sfatherName"), (String) httpSession.getAttribute("sgender"), marks,
				(String) httpSession.getAttribute("smotherName"), (String) httpSession.getAttribute("sname"), password,
				presentClass);
		httpSession.removeAttribute("sname");
		httpSession.removeAttribute("semail");
		httpSession.removeAttribute("smotherName");
		httpSession.removeAttribute("sfatherName");
		httpSession.removeAttribute("sgender");
		model.addAttribute("students", studentService.getAllStudents());
		return "adminHome";
	}
}
