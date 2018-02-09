package com.student.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.dto.Issue;
import com.student.app.dto.Post;
import com.student.app.service.IssueService;
import com.student.app.service.PostService;

@RestController
public class PostRestController {
//	private Logger logger = Logger.getLogger(this.getClass());
//	PostService postService;
//
//	public void setPostService(PostService  postService) {
//		this.postService = postService;
//	}
//	@RequestMapping(value = "/post", method = RequestMethod.GET, produces = "application/json")
//	public ResponseEntity<List<Post>> listAllPosts(HttpServletRequest request,HttpServletResponse response) {
//		logger.info("listAllPosts() entered");
//		List<Post> posts = postService.getAllPosts();
//		if (posts.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
//	}
	

}
