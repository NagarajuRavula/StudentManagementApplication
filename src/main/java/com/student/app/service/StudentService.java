package com.student.app.service;

import java.util.List;
import java.util.Properties;

import com.student.app.dto.Student;

public interface StudentService {

	public List<Student> getAllStudents();

	public Student getStudentByEmail(String email);

	public Properties getProperties();

	public int deleteById(int id);

	public void saveStudent(Student student);

	public Student getStudentById(int id);

	public void updateStudent(Student student);
	
	
}
