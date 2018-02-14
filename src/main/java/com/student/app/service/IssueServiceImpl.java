package com.student.app.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.student.app.dao.IssueDao;
import com.student.app.dto.Issue;

public class IssueServiceImpl implements IssueService{
	
	IssueDao issueDao;
	private Logger logger = Logger.getLogger(this.getClass());
	
	public void setIssueDao(IssueDao issueDao) {
		this.issueDao = issueDao;
	}
	

	@Override
	public List<Issue> getAllIssues() {
		logger.info("getAllIssues() entered:");
		return issueDao.getAllIssues();
	}


	@Override
	public int issueToResolve(int id) {
		logger.info("issueToResolve() entered:");
		return issueDao.issueToResolve(id);
	}


	@Override
	public int issueToIgnore(int id) {
		logger.info("issueToIgnore() entered:");
		return issueDao.issueToIgnore(id);
	}


	@Override
	public int saveIssue(Issue issue) {
		logger.info("saveIssue() entered:");
		return issueDao.saveIssue(issue);
	}

}
