package com.student.app.dao;

import java.util.List;

import com.student.app.dto.Student;

public interface StudentDao {

	public List<Student> getAllStudents();
	public Student getStudentByEmail(String email);
	 public Student updateStudent(double attendence,int classrank,String email,String fatherName,String gender,int id,
	    		double marks,String motherName,String name,String password,int presentClass);
}
