package com.student.app.controller;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.app.service.StudentService;

@Controller
public class EditController {

	private Logger logger = Logger.getLogger(this.getClass());
	StudentService studentService;
	HttpSession httpSession;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/editStudentDetails", method = RequestMethod.GET, produces = "application/json")
	public String editStudentDetails(@PathParam("email") String email, ModelMap model) {
		logger.info("editStudentDetails() entered with email:"+email);
		model.addAttribute("student", studentService.getStudentByEmail(email));
		return "editStudentDetails";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "application/json")
	public String edit(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("originalEmail") String originalEmail,
			@RequestParam("fatherName") String fatherName, @RequestParam("motherName") String motherName,
			@RequestParam("gender") String gender, @RequestParam("presentClass") int presentClass,
			@RequestParam("marks") double marks, @RequestParam("attendence") double attendence,
			@RequestParam("classrank") int classrank, @RequestParam("password") String password,
			HttpServletRequest request, ModelMap model) {
		logger.info("edit() entered");
		Properties properties = studentService.getProperties();
		if (!email.equals(originalEmail)) {
			if (studentService.getStudentByEmail(email) != null) {
				logger.debug("edit() failed due to email edited is alreday exits");
				model.addAttribute("errorMessage", properties.getProperty("EXISTING_USER"));
				model.addAttribute("student", studentService.getStudentByEmail(originalEmail));
				return "editStudentDetails";
			}
		}
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

	@RequestMapping(value = "/editGoBack", method = RequestMethod.GET, produces = "application/json")
	public String editGoBack(HttpServletRequest request, ModelMap model) {
		logger.info("editGoBack() entered");
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
