package com.student.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.app.dao.StudentDao;
import com.student.app.dto.Student;

@Component
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentdao;

	@Override
	public List<Student> getAllStudents() {

		return studentdao.getAllStudents();
	}

	@Override
	public Student getStudentByEmail(String email) {

		return studentdao.getStudentByEmail(email);
	}

	@Override
	public Student updateStudent(double attendence, int classrank, String email, String fatherName, String gender, int id,
			double marks, String motherName, String name, String password, int presentClass) {
		
		return studentdao.updateStudent(attendence, classrank, email, fatherName, gender, id, marks, motherName, name, password, presentClass);
	}

	


}













