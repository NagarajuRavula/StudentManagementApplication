
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>edit details</title>

<link rel="stylesheet"
	href=${pageContext.request.contextPath}/css/editStudentDetailsPage.css>
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<script
	src=${pageContext.request.contextPath}/js/studentDetailsValidation.js>	
</script>
<body onload="setGender('${student.getGender()}')">

 <%@include file="header.jsp" %>
	<center>
	

		<c:if test="${not empty errorMessage}">
			<p>Error: ${errorMessage}</p>
		</c:if>


		<button id="backButton" onclick="location.href='editGoBack'">Go
			Back</button>
		<button id="editButton" onclick="enableFileds()">Edit Details</button>

		<div class="container">
			<form id="contact" action=${pageContext.request.contextPath}/edit
				onsubmit="return validateEditDetailsForm()" method="post">
				<h3>${student.getRole()} Details</h3>
				<h4>click on Edit button to change details</h4>
				<fieldset id="formFields" disabled>
					<fieldset>
						<input type="hidden" id="id" name="id" value='${student.getId()}'>
					</fieldset>
					<fieldset>
						<input type="text" name="name" id="name" tabindex="1"
							value='${student.getName()}' data-tooltip aria-haspopup="true"
							title="Student Name" onchange="return checkName(this)" required>
						<p id="errorMessageforname"></p>
					</fieldset>
					<fieldset>
						<input type="email" id="email" name="email" tabindex="2"
							value='${student.getEmail()}' data-tooltip aria-haspopup="true"
							title="Student Email" required>
					</fieldset>
					<fieldset>
						<input type="hidden" id="'originalEmail'" name="originalEmail"
							value='${student.getEmail()}'>
					</fieldset>
					<fieldset>
						<input type="hidden" id="'role'" name="role"
							value='${student.getRole()}'>
					</fieldset>
					<fieldset>
						<input type="text" tabindex="3" id="fatherName" name="fatherName"
							value='${student.getFatherName()}' data-tooltip
							aria-haspopup="true" title="Student Father Name"
							onchange="return checkName(this)" required>
						<p id="errorMessageforfatherName"></p>
					</fieldset>
					<fieldset>
						<input type="text" tabindex="4" id="motherName" name="motherName"
							value='${student.getMothername()}' data-tooltip
							aria-haspopup="true" title="Student Mother Name"
							onchange="return checkName(this)" required>
						<p id="errorMessageformotherName"></p>
					</fieldset>
					<fieldset>
						<select name="gender" id="gender" data-tooltip
							aria-haspopup="true" title="Student Gender">
							<option>Gender</option>
							<option>Male</option>
							<option>Female</option>
							<option>Other</option>
						</select>
						<p id="errorMessageforgender"></p>
					</fieldset>

					<fieldset>
						<input type="number" name="presentClass" id="presentClass" min=1
							max=10 tabindex="6" value='${student.getPresentClass()}'
							data-tooltip aria-haspopup="true" title="Student Present Class"
							required>
					</fieldset>
					<fieldset>
						<input type="number" name="marks" id="marks" tabindex="7" min=1
							max=600 value='${student.getMarks()}' data-tooltip
							aria-haspopup="true" title="Student Marks" required>
					</fieldset>
					<fieldset>
						<input type="number" tabindex="8" min=1 max=100 name="attendence"
							id="attendence" value='${student.getAttendence()}' data-tooltip
							aria-haspopup="true" title="Student Attendence" required>
					</fieldset>
					<fieldset>
						<input type="number" tabindex="9" name="classrank" id="classrank"
							value='${student.getClassrank()}' data-tooltip
							aria-haspopup="true" title="Student Class Rank" required>
					</fieldset>
					<fieldset>
						<input type="password" tabindex="10" name="password" id="password"
							value='${student.getPassword()}' data-tooltip
							aria-haspopup="true" title="Student Login Password"
							onchange="return checkPassword(this)" required>
						<p id="errorMessageforpassword"></p>
					</fieldset>
					<fieldset>
						<button name="submit" type="submit" id="educational-submit" >Update
							details</button>
					</fieldset>

				</fieldset>
			</form>
		</div>


	</center>
</body>
</head>
</html>