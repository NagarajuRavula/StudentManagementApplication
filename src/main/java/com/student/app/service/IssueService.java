package com.student.app.service;

import java.util.List;

import com.student.app.dto.Issue;

public interface IssueService {

	public List<Issue> getAllIssues();
	
	public int issueToResolve(int id);
	
	public int issueToIgnore(int id);
	
	public int saveIssue(Issue issue);
}
