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
		this.errorProperties=errorProperties;
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
		 logger.info("getStudentByEmail() entered with email:"+email);
		return studentDao.getStudentByEmail(email);
	}

	@Override
	public Student updateStudent(double attendence, int classrank, String email, String fatherName, String gender,
			int id, double marks, String motherName, String name, String password, int presentClass) {
		logger.info("updateStudent() entered with id:"+id);
		return studentDao.updateStudent(attendence, classrank, email, fatherName, gender, id, marks, motherName, name,
				password, presentClass);
	}

	

	@Override
	public void saveStudent(double attendence, int classrank, String email, String fatherName, String gender,
			double marks, String motherName, String name, String password, int presentClass) {
		logger.info("saveStudent() entered");
		studentDao.saveStudent(attendence, classrank, email, fatherName, gender, marks, motherName, name, password, presentClass);
		
	}

	@Override
	public Properties getProperties() {
		
		return errorProperties.getProperties();
	}
	@Override
	public int deleteById(int id) {
		logger.info("deleteById() entered with id:"+id);
		return studentDao.deleteById(id);
	}

	

}
