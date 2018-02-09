package com.student.app.dao;

import java.util.List;

import com.student.app.dto.Issue;

public interface IssueDao {

	public List<Issue> getAllIssues();
	
    public int issueToResolve(int id);
	
	public int issueToIgnore(int id);
}
