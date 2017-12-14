package com.student.app.service;

import java.util.List;
import java.util.Properties;

import com.student.app.dao.StudentDao;
import com.student.app.dto.Student;
import com.student.app.utils.ErrorProperties;

public class StudentServiceImpl implements StudentService {
	StudentDao studentDao;

	ErrorProperties errorProperties;
	public void setErrorProperties(ErrorProperties errorProperties) {
		this.errorProperties=errorProperties;
	}
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
	public void deleteStudent(Integer id) {
		studentDao.deleteStudent(id);
	}

	@Override
	public void saveStudent(double attendence, int classrank, String email, String fatherName, String gender,
			double marks, String motherName, String name, String password, int presentClass) {
		studentDao.saveStudent(attendence, classrank, email, fatherName, gender, marks, motherName, name, password, presentClass);
		
	}

	@Override
	public Properties getProperties() {
		
		return errorProperties.getProperties();
	}

	

}
