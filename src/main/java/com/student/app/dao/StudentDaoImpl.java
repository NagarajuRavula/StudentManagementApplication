package com.student.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.student.app.dto.Student;
import com.student.app.repository.StudentRepository;

@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {

		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Student getStudentByEmail(String email) {

		return studentRepository.getStudentByEmail(email);
	}

	@Override
	public Student updateStudent(double attendence, int classrank, String email, String fatherName, String gender, int id,
			double marks, String motherName, String name, String password, int presentClass) {
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

}
