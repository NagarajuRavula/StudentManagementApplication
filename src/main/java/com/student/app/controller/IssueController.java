package com.student.app.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.dto.Issue;
import com.student.app.dto.Post;
import com.student.app.dto.Student;
import com.student.app.service.IssueService;

@RestController
public class IssueController {

	private Logger logger = Logger.getLogger(this.getClass());
	IssueService issueService;
	HttpSession httpSession;

	public void setIssueService(IssueService  issueService) {
		this.issueService = issueService;
	}
	@RequestMapping(value = "/issue", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Issue>> listAllIssues(HttpServletRequest request,HttpServletResponse response) {
		logger.info("listAllIssues() entered");
		List<Issue> issues = issueService.getAllIssues();
		if (issues.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Issue>>(issues, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/issueToResolve/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> issueToResolve(@PathVariable("id") int id, HttpServletRequest request,HttpServletResponse response) {
		logger.info("issuetoResolue() entered with id:" + id);
		int status = issueService.issueToResolve(id);
		if (status > 0) {
			logger.debug("issueToResolue() successfull ----;;;;''''");
			return new ResponseEntity<String>("UPDATED SUCCESSFUL", HttpStatus.OK);
		} else {
			logger.debug("issueToResolue() failed");
			return new ResponseEntity<String>("ERROR OCCURED",  HttpStatus.NOT_FOUND);
		}

	}
	
	
	@RequestMapping(value = "/issueToIgnore/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> issueToIgnore(@PathVariable("id") int id, HttpServletRequest request,HttpServletResponse response) {
		logger.info("issueToIgnore() entered with id:" + id);
		int status = issueService.issueToIgnore(id);
		if (status > 0) {
			logger.debug("issueToIgnore() successfull ----;;;;''''");
			return new ResponseEntity<String>("UPDATED SUCCESSFUL", HttpStatus.OK);
		} else {
			logger.debug("issueToIgnore() failed");
			return new ResponseEntity<String>("ERROR OCCURED",  HttpStatus.NOT_FOUND);
		}

	}
	
	
	@RequestMapping(value = "/saveIssue", method = RequestMethod.POST)
	public ResponseEntity<String> saveIssue(@RequestParam("issueType") String issueType,@RequestParam("textArea") String issue,ModelMap model,HttpServletRequest request,HttpServletResponse response) {
		
		logger.info("saveIssue() entered");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpSession=request.getSession(false);
		Student student=(Student) httpSession.getAttribute("loggedInUser");
	
		Issue issueObj=new Issue();
		issueObj.setIssue(issue);
		issueObj.setIssueType(issueType);

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		issueObj.setReportedDate(now);
		issueObj.setStatus("pending");
		issueObj.setStudent(student);
		int status=issueService.saveIssue(issueObj);
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
	
	
}
