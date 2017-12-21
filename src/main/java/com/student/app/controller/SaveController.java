package com.student.app.controller;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.app.service.StudentService;

@Controller
public class SaveController {

	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;
	HttpSession httpSession;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET, produces = "application/json")
	public String addStudent(ModelMap model) {
        logger.info("addStudent() entered");
		return "studentPersonalDetails";
	}

	@RequestMapping(value = "/studentPersonalDetails", method = RequestMethod.POST, produces = "application/json")
	public String studentPersonalDetails(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("motherName") String motherName, @RequestParam("fatherName") String fatherName,
			@RequestParam("gender") String gender, HttpServletRequest request, ModelMap model) {
        logger.info("studentPersonalDetails() entered");
		Properties properties = studentService.getProperties();
		if (studentService.getStudentByEmail(email) != null) {
			logger.debug("studentPersonalDetails() failed due to email is already registered");
			model.addAttribute("errorMessage", email+" "+properties.getProperty("EXISTING_USER"));
			model.addAttribute("sname",name);
			model.addAttribute("semail", email);
			model.addAttribute("sfatherName",fatherName);
			model.addAttribute("smotherName",motherName);
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

	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST, produces = "application/json")
	public String saveStudent(@RequestParam("presentclass") int presentClass, @RequestParam("marks") double marks,
			@RequestParam("attendence") double attendence, @RequestParam("classrank") int classRank,
			@RequestParam("password") String password, ModelMap model) {
		if(httpSession.getAttribute("semail")==null) {
			model.addAttribute("students", studentService.getAllStudents());
			return "adminHome";
		}
		logger.info("saveStudent() entered");
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
