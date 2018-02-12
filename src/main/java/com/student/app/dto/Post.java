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
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotNull(message = "post can not be empty")
	@Column(length=512)
	private String post;
	private String postType;
	private Date postedDate;
	
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private Student admin;

	
	
	
	public Post() {
		super();
	}
	

	public Post(Integer id, String post, String postType, Date postedDate, Student admin) {
		super();
		this.id = id;
		this.post = post;
		this.postType = postType;
		this.postedDate = postedDate;
		this.admin = admin;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public Student getAdmin() {
		return admin;
	}

	public void setAdmin(Student admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", post=" + post + ", postType=" + postType + ", postedDate=" + postedDate
				+ ", admin=" + admin + "]";
	}
	
	
}
