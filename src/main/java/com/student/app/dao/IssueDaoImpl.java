package com.student.app.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.student.app.dto.Issue;
import com.student.app.repository.IssueRepository;

public class IssueDaoImpl implements IssueDao {
	
	
	private Logger logger = Logger.getLogger(this.getClass());
	IssueRepository issueRepository;
	
	public void setIssueRepository(IssueRepository issueRepository) {
		this.issueRepository = issueRepository;
	}
    
	@Override
	public List<Issue> getAllIssues() {
		logger.info("getAllIssues() entered:");
		return (List<Issue>)issueRepository.findAll();
	}

	@Override
	public int issueToResolve(int id) {
        logger.info("issueToResolve() entered :");
        Issue issue=issueRepository.findOne(id);
        issue.setStatus("resolved");
        long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
        issue.setResolvedDate(now);
        if((issueRepository.save(issue)==null))
        	return 0;
        else 
        	return 1;
	}

	@Override
	public int issueToIgnore(int id) {
		 logger.info("issueToIgnore() entered:");
	        Issue issue=issueRepository.findOne(id);
	        issue.setStatus("ignored");
	        long nowMillis = System.currentTimeMillis();
			Date now = new Date(nowMillis);
	        issue.setIgnoredDate(now);
	        if((issueRepository.save(issue)==null))
	        	return 0;
	        else 
	        	return 1;
	}

	@Override
	public int saveIssue(Issue issue) {
		logger.info("saveIssue() entered:");
		if(issueRepository.save(issue)==null) 
			return 0;
		else
			return 1;
	}

}
