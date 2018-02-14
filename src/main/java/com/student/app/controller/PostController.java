package com.student.app.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.student.app.dto.Student;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.dto.Post;
import com.student.app.service.PostService;

@RestController
public class PostController {

	private Logger logger = Logger.getLogger(this.getClass());
	PostService postService;
	HttpSession httpSession;

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	@RequestMapping(value = "/savePost", method = RequestMethod.POST)
	public ResponseEntity<String> savePost(@RequestParam("postType") String postType,@RequestParam("textArea") String post,ModelMap model,HttpServletRequest request,HttpServletResponse response) {
		logger.info("savePost() entered");
		System.out.println("----------------------------------------------->");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpSession=request.getSession(false);
		Student admin=(Student) httpSession.getAttribute("loggedInUser");
	
		Post postObj=new Post();
		postObj.setAdmin(admin);
		postObj.setPost(post);
		postObj.setPostType(postType);
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		postObj.setPostedDate(now);
		int status=postService.savePost(postObj);
		System.out.println("status----------------->:"+status);
		if(status==1)  {
			httpHeaders.add("success", "record saved successfully!");
			return new ResponseEntity<String>("Posted Successfully!", httpHeaders,HttpStatus.OK);
		}
		else {
			httpHeaders.add("error", "Error occured while saving!");
			return new ResponseEntity<String>("Error Occurd!",httpHeaders, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/post", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Post>> listAllPosts(HttpServletRequest request,HttpServletResponse response) {
		logger.info("listAllPosts() entered");
		List<Post> posts = postService.getAllPosts();
		if (posts.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}
	
	
	
	
}
