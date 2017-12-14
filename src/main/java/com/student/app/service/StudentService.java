package com.student.app.service;
import java.util.List;
import java.util.Properties;

import com.student.app.dto.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	public Student getStudentByEmail(String email);
    public Student updateStudent(double attendence,int classrank,String email,String fatherName,String gender,int id,
    		double marks,String motherName,String name,String password,int presentClass);
    public void deleteStudent(Integer id);
    public void saveStudent(double attendence,int classrank,String email,String fatherName,String gender,
    		double marks,String motherName,String name,String password,int presentClass);
    public Properties getProperties();
    
}


