package com.student.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull(message = "issue can not be empty")
	@Column(length=512)
	private String issue;
    private Date reportedDate;
    private Date resolvedDate;
    private Date ignoredDate;
    private String status;
    
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student ;

    public Issue() {
		super();
	}
	public Issue(Integer id, String issue, Date reportedDate, Date resolvedDate, Date ignoredDate,String status, Student student) {
		super();
		this.id = id;
		this.issue = issue;
		this.reportedDate = reportedDate;
		this.resolvedDate = resolvedDate;
		this.ignoredDate = ignoredDate;
		this.status = status;
		this.student = student;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Date getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}

	public Date getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public Date getIgnoredDate() {
		return ignoredDate;
	}

	public void setIgnoredDate(Date ignoredDate) {
		this.ignoredDate = ignoredDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public String toString() {
		return "Issue [id=" + id + ", issue=" + issue + ", reportedDate=" + reportedDate + ", resolvedDate="
				+ resolvedDate + ", ignoredDate=" + ignoredDate +", status=" +status + ", student=" + student + "]";
	}	
}
