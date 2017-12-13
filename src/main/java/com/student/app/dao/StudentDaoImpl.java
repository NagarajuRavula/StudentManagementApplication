package com.student.app.dao;

import java.util.List;

import com.student.app.dto.Student;
import com.student.app.repository.StudentRepository;

public class StudentDaoImpl implements StudentDao {

	StudentRepository studentRepository;

	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {

		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student getStudentByEmail(String email) {
		return studentRepository.getStudentByEmail(email);
	}

	@Override
	public Student updateStudent(double attendence, int classrank, String email, String fatherName, String gender,
			int id, double marks, String motherName, String name, String password, int presentClass) {
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
		student.setPresentClass(presentClass);
		return studentRepository.save(student);

	}

	@Override
	public void deleteStudent(Integer id) {
		studentRepository.delete(id);
	}

	@Override
	public void saveStudent(double attendence, int classrank, String email, String fatherName, String gender,
			double marks, String motherName, String name, String password, int presentClass) {
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

	

}
