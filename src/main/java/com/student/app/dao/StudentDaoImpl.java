package com.student.app.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.student.app.dto.Student;
import com.student.app.repository.StudentRepository;

public class StudentDaoImpl implements StudentDao {

	private Logger logger = Logger.getLogger(this.getClass());
	StudentRepository studentRepository;

	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		logger.info("getAllStudents() entered");
		return (List<Student>) studentRepository.findByRole("student");
	}

	@Override
	public Student getStudentByEmail(String email) {
		logger.info("getStudentByEmail() entered with email:" + email);
		return studentRepository.getStudentByEmail(email);
	}

	@Override
	public int deleteById(int id) {
		logger.info("deleteById() entered with id:" + id);
		return studentRepository.deleteById(id);
	}

	@Override
	public void saveStudent(Student student) {

		studentRepository.save(student);
	}

	@Override
	public Student getStudentById(int id) {

		return studentRepository.findOne(id);
	}

	
	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
	}

}
