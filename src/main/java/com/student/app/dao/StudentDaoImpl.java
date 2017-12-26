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
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student getStudentByEmail(String email) {
		logger.info("getStudentByEmail() entered with email:"+email);
		return studentRepository.getStudentByEmail(email);
	}

	@Override
	public Student updateStudent(double attendence, int classrank, String email, String fatherName, String gender,
			int id, double marks, String motherName, String name, String password, int presentClass) {
		logger.info("updateStudent() entered");
		Student student = new Student();
		student.setAttendence(attendence);
		student.setClassrank(classrank);
		student.setEmail(email);
		student.setFatherName(fatherName);
		student.setGender(gender);
		student.setId(id);
		student.setMarks(marks);
		student.setMothername(motherName);
		student.setName(name);
		student.setPassword(password);
		student.setRole("student");
		student.setPresentClass(presentClass);
		return studentRepository.save(student);

	}

	

	@Override
	public void saveStudent(double attendence, int classrank, String email, String fatherName, String gender,
			double marks, String motherName, String name, String password, int presentClass) {
		logger.info("saveStudent() entered");
		Student student = new Student();
		student.setAttendence(attendence);
		student.setClassrank(classrank);
		student.setEmail(email);
		student.setFatherName(fatherName);
		student.setGender(gender);
		student.setMarks(marks);
		student.setMothername(motherName);
		student.setName(name);
		student.setRole("student");
		student.setPassword(password);
		student.setPresentClass(presentClass);
		studentRepository.save(student);
		
	}

	@Override
	public int deleteById(int id) {
	    logger.info("deleteById() entered with id:"+id);
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
