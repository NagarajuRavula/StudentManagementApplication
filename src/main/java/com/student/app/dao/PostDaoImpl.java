package com.student.app.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.student.app.dto.Post;
import com.student.app.repository.PostRepository;

public class PostDaoImpl implements PostDao{
	

	private Logger logger = Logger.getLogger(this.getClass());
	PostRepository postRepository;
	
	public void setIssueRepository(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public int savePost(Post postObj) {
		logger.info("savePost() entered:");
		if(postRepository.save(postObj)==null)
			return 0;
		else
			return 1;
	}

	@Override
	public List<Post> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

}
