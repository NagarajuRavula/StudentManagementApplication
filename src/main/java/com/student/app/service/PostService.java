package com.student.app.service;
import java.util.List;

import com.student.app.dto.Post;


public interface PostService {

	public int savePost(Post postObj);
	
	public List<Post> getAllPosts();
}
