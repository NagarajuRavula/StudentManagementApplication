package com.student.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.student.app.dto.Issue;

public interface IssueRepository extends CrudRepository<Issue, Integer>{

}
