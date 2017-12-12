package com.student.app.service;
import java.util.List;
import com.student.app.dto.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	public Student getStudentByEmail(String email);
    public Student updateStudent(double attendence,int classrank,String email,String fatherName,String gender,int id,
    		double marks,String motherName,String name,String password,int presentClass);
}


