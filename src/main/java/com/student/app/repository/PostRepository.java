package com.student.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.student.app.dto.Post;


public interface PostRepository extends CrudRepository<Post, Integer>{

}
