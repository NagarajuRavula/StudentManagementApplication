package com.student.app.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.student.app.dao.IssueDao;
import com.student.app.dao.PostDao;
import com.student.app.dto.Post;

public class PostServiceImpl implements PostService {
	
	PostDao postDao;
	private Logger logger = Logger.getLogger(this.getClass());
	
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	

	@Override
	public int savePost(Post postObj) {
		return postDao.savePost(postObj);
	}

	@Override
	public List<Post> getAllPosts() {
		logger.info("getAllPosts() entered:");
		return postDao.getAllPosts();
	}

}
