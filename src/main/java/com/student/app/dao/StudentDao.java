package com.student.app.dao;

import java.util.List;

import com.student.app.dto.Student;

public interface StudentDao {

	public List<Student> getAllStudents();
	public Student getStudentByEmail(String email);
	 public Student updateStudent(double attendence,int classrank,String email,String fatherName,String gender,int id,
	    		double marks,String motherName,String name,String password,int presentClass);
	
	 public void saveStudent(double attendence,int classrank,String email,String fatherName,String gender,
	    		double marks,String motherName,String name,String password,int presentClass);
	 public int deleteById(int id);
	 public void saveStudent(Student student);
	 public Student getStudentById(int id);
	 public void updateStudent(Student student);
}
