package com.student.app.controller;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.app.dto.Student;
import com.student.app.service.StudentService;

@Controller
@RequestMapping("/")
public class SaveController {

	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;
	HttpSession httpSession;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/addStudent")
	public String addStudent(ModelMap model) {
		logger.info("addStudent() entered");
		return "studentPersonalDetails";
	}

	@RequestMapping(value = "/studentPersonalDetails")
	public String studentPersonalDetails(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("motherName") String motherName, @RequestParam("fatherName") String fatherName,
			@RequestParam("gender") String gender, HttpServletRequest request, ModelMap model) {
		logger.info("studentPersonalDetails() entered");
		Properties properties = studentService.getProperties();
		if (studentService.getStudentByEmail(email) != null) {
			logger.debug("studentPersonalDetails() failed due to email is already registered");
			model.addAttribute("errorMessage", email + " " + properties.getProperty("EXISTING_USER"));
			model.addAttribute("sname", name);
			model.addAttribute("semail", email);
			model.addAttribute("sfatherName", fatherName);
			model.addAttribute("smotherName", motherName);
			return "studentPersonalDetails";
		}
		httpSession = request.getSession(false);
		httpSession.setAttribute("sname", name);
		httpSession.setAttribute("semail", email);
		httpSession.setAttribute("smotherName", motherName);
		httpSession.setAttribute("sfatherName", fatherName);
		httpSession.setAttribute("sgender", gender);
		return "studentEducationDetails";
	}

	@RequestMapping(value = "/saveStudent")
	public String saveStudent(@RequestParam("presentclass") int presentClass, @RequestParam("marks") double marks,
			@RequestParam("attendence") double attendence, @RequestParam("classrank") int classRank,
			@RequestParam("password") String password, ModelMap model) {
		if (httpSession.getAttribute("semail") == null) {
			model.addAttribute("students", studentService.getAllStudents());
			return "adminHome";
		}
		logger.info("saveStudent() entered");
		Student student = new Student();
		student.setAttendence(attendence);
		student.setClassrank(classRank);
		student.setEmail((String) httpSession.getAttribute("semail"));
		student.setFatherName((String) httpSession.getAttribute("sfatherName"));
		student.setGender((String) httpSession.getAttribute("sgender"));
		student.setMarks(marks);
		student.setMothername((String) httpSession.getAttribute("smotherName"));
		student.setName((String) httpSession.getAttribute("sname"));
		student.setPassword(password);
		student.setPresentClass(presentClass);
		studentService.saveStudent(student);

		httpSession.removeAttribute("sname");
		httpSession.removeAttribute("semail");
		httpSession.removeAttribute("smotherName");
		httpSession.removeAttribute("sfatherName");
		httpSession.removeAttribute("sgender");
		model.addAttribute("students", studentService.getAllStudents());
		return "adminHome";
	}
}
