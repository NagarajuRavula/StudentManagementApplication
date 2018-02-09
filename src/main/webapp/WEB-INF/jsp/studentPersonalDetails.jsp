<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Student Personal Details</title>
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/css/studentPersonalDetailsPage.css>
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<script
	src=${pageContext.request.contextPath}/js/studentDetailsValidation.js></script>
<body onload="setGender('${sgender}')">

 <%@include file="header.jsp" %>
	<center>
		<c:if test="${not empty errorMessage}">
			<p id="message">Error: ${errorMessage}</p>
		</c:if>
		<div class="container">
			<form id="contact"
				action=${pageContext.request.contextPath}/studentPersonalDetails
				method="post" onsubmit="return checkGenderAndValidatePersonalForm()">
				<h3>Student registration form</h3>
				<h4>Enter the student personal data</h4>
				<fieldset>
					<input placeholder="Enter name" type="text" name="name" id="name"
						tabindex="1" onchange="return checkName(this)" value="${sname}"
						autofocus required>
					<p id="errorMessageforname"></p>
				</fieldset>
				<fieldset>
					<input placeholder="Enter Email Address" type="email" id="email"
						name="email" tabindex="2" value="${semail}" required>
					<p id="errorMessageforemail"></p>
				</fieldset>
				<fieldset>
					<input placeholder="Enter Father Name" type="text" tabindex="3"
						id="fatherName" name="fatherName" onchange="return checkName(this)"
						value="${sfatherName}" required>
					<p id="errorMessageforfatherName"></p>
				</fieldset>
				<fieldset>
					<input placeholder="Enter Mother Name" type="text" tabindex="4"
						id="motherName" name="motherName" onchange="return checkName(this)"
						value="${smotherName}" required>
					<p id="errorMessageformotherName"></p>
				</fieldset>
				<fieldset>
					<select name="gender" id="gender">
						<option>Gender</option>
						<option>Male</option>
						<option>Female</option>
						<option>Other</option>
					</select>
					<p id="errorMessageforgender"></p>
				</fieldset>
				<fieldset>
					<button name="submit" type="submit" id="personal-submit">Next</button>
				</fieldset>
			</form>
		</div>


	</center>
   <%@include file="footer.jsp" %>
</body>
</html>