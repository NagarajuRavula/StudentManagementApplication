package com.student.app.dao;

import java.util.List;

import com.student.app.dto.Post;

public interface PostDao {

    public int savePost(Post postObj);
	
	public List<Post> getAllPosts();
}
