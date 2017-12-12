package com.student.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.student.app.dto.Student;
import com.student.app.service.StudentService;

@Controller
public class EditController {

	StudentService studentService;
    HttpSession httpSession;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

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
			@RequestParam("classrank") int classrank, @RequestParam("password") String password,HttpServletRequest request) {
		Student student = studentService.updateStudent(attendence, classrank, email, fatherName, gender, id, marks,
				motherName, name, password, presentClass);
		httpSession=request.getSession(false);
		if(httpSession.getAttribute("role").equals("admin"))
		    return new ModelAndView("adminHome","students",studentService.getAllStudents());
		else
		return new ModelAndView("studentHome", "student", student);
	}
	
	
	@RequestMapping("/editGoBack")
	public ModelAndView editGoBack(HttpServletRequest request ) {
		httpSession=request.getSession(false);
		if(httpSession.getAttribute("role").equals("admin"))
		    return new ModelAndView("adminHome","students",studentService.getAllStudents());
		else {
			String email=(String)httpSession.getAttribute("email");
			return new ModelAndView("studentHome","student",studentService.getStudentByEmail(email));
		}
	
		
	}
	
	
	
	
}
