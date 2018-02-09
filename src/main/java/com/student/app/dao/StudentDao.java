package com.student.app.dao;

import java.util.List;

import com.student.app.dto.Student;

public interface StudentDao {

	public List<Student> getAllStudents();

	public Student getStudentByEmail(String email);

	public int deleteById(int id);

	public void saveStudent(Student student);

	public Student getStudentById(int id);

	public void updateStudent(Student student);
	
	
}
