package com.student.app.service;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.student.app.dao.StudentDao;
import com.student.app.dto.Student;
import com.student.app.utils.ErrorProperties;


public class StudentServiceImpl implements StudentService {
	StudentDao studentDao;
	private Logger logger = Logger.getLogger(this.getClass());
	ErrorProperties errorProperties;

	public void setErrorProperties(ErrorProperties errorProperties) {
		this.errorProperties = errorProperties;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> getAllStudents() {
		logger.info("getAllStudents() entered");
		return studentDao.getAllStudents();
	}

	@Override
	public Student getStudentByEmail(String email) {
		logger.info("getStudentByEmail() entered with email:" + email);
		return studentDao.getStudentByEmail(email);
	}

	@Override
	public Properties getProperties() {

		return errorProperties.getProperties();
	}

	@Override
	public int deleteById(int id) {
		logger.info("deleteById() entered with id:" + id);
		return studentDao.deleteById(id);
	}

	@Override
	public void saveStudent(Student student) {
		studentDao.saveStudent(student);

	}

	@Override
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

	
	@Override
	public void updateStudent(Student student) {
		studentDao.updateStudent(student);

	}

}
