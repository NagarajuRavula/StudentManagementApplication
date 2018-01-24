package com.student.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.student.app.dto.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

	public Student getStudentByEmail(String email);
	
//	    @Modifying
//	    @Transactional
//	    @Query("delete from Student std where std.id = ?1")
//	    void deleteUsersByFirstName(String firstName);
	
	    public int deleteById(int id);

}
