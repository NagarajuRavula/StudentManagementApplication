package com.student.app.service;

import java.util.List;

import com.student.app.dao.StudentDao;
import com.student.app.dto.Student;

public class StudentServiceImpl implements StudentService {
	StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> getAllStudents() {

		return studentDao.getAllStudents();
	}

	@Override
	public Student getStudentByEmail(String email) {
		return studentDao.getStudentByEmail(email);
	}

	@Override
	public Student updateStudent(double attendence, int classrank, String email, String fatherName, String gender,
			int id, double marks, String motherName, String name, String password, int presentClass) {

		return studentDao.updateStudent(attendence, classrank, email, fatherName, gender, id, marks, motherName, name,
				password, presentClass);
	}

	@Override
	public void deleteStudent(Long id) {
		
	}

}
