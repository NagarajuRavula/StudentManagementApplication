package com.student.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.student.app.dto.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

	public Student getStudentByEmail(String email);
	
//	    @Modifying
//	    @Transactional
//	    @Query("delete from Student std where std.id = ?1")
//	    void deleteUsersByFirstName(String firstName);
	     
	

	    /**
	     * 
	     * @param id
	     * @return
	     * 
	     * spring have a functionality of creating query from method 
	     * name it self by proper using of keywords and entity properties..
	     * first it parses the method by eliminating prefixes and take the method parameters as a search strings
	     */
        @Transactional
	    public int deleteById(int id);
	    
        List<Student> findByRole(String role);

}
