package com.student.app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(hidden = true)
	private Integer id;

	@NotNull(message = "presentClass can not be empty")
	private Integer presentClass;

	@NotNull(message = "classrank can not be empty")
	private Integer classrank;

	@NotNull(message = "marks can not be empty")
	private Double marks;

	@NotNull(message = "attendence can not be empty")
	private Double attendence;

	@NotNull(message = "name can not be empty")
	private String name;

	@NotNull(message = "email can not be empty")
	@Email
	private String email;

	@NotNull(message = "fatherName can not be empty")
	private String fatherName;

	@NotNull(message = "motherName can not be empty")
	private String mothername;

	@NotNull(message = "gender can not be empty")
	private String gender;

	@NotNull(message = "password can not be empty")
	@Size(min = 5, max = 15)
	private String password;
	
	@ApiModelProperty(hidden = true)
	private String role = "student";

	public Student() {
		super();
	}

	public Student(Integer id, Integer presentClass, Integer classrank, Double marks, Double attendence, String name,
			String email, String fatherName, String mothername, String gender, String password, String role) {
		super();
		this.id = id;
		this.presentClass = presentClass;
		this.classrank = classrank;
		this.marks = marks;
		this.attendence = attendence;
		this.name = name;
		this.email = email;
		this.fatherName = fatherName;
		this.mothername = mothername;
		this.gender = gender;
		this.password = password;
		this.role = role;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPresentClass() {
		return presentClass;
	}

	public void setPresentClass(Integer presentClass) {
		this.presentClass = presentClass;
	}

	public Integer getClassrank() {
		return classrank;
	}

	public void setClassrank(Integer classrank) {
		this.classrank = classrank;
	}

	public Double getMarks() {
		return marks;
	}

	public void setMarks(Double marks) {
		this.marks = marks;
	}

	public Double getAttendence() {
		return attendence;
	}

	public void setAttendence(Double attendence) {
		this.attendence = attendence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMothername() {
		return mothername;
	}

	public void setMothername(String mothername) {
		this.mothername = mothername;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", presentClass=" + presentClass + ", classrank=" + classrank + ", marks=" + marks
				+ ", attendence=" + attendence + ", name=" + name + ", email=" + email + ", fatherName=" + fatherName
				+ ", mothername=" + mothername + ", gender=" + gender + ", password=" + password + ", role=" + role
				+ "]";
	}
}
