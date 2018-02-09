<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Education Details</title>
</head>
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/css/studentEducationDetailsPage.css>
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>
	<script
		src=${pageContext.request.contextPath}/js/studentDetailsValidation.js></script>
<body>
   <%@include file="header.jsp" %>
	<center>
		<div class="container">

			<form id="contact"
				action=${pageContext.request.contextPath}/saveStudent
				onsubmit="return validateEducationForm()" method="post">
				<h3>Student registration form</h3>
				<h4>Enter the student Educational data</h4>

				<fieldset>
					<input placeholder="Class Standard (1-10)" type="number"
						name="presentclass" min=1 max=10 tabindex="1" autofocus required>
					<p id="errorMessageforpresentclass"></p>
				</fieldset>
				<fieldset>
					<input placeholder="Marks (1-600)" type="number" name="marks"
						tabindex="2" min=1 max=600 required>
					<p id="errorMessageformarks"></p>
				</fieldset>
				<fieldset>
					<input placeholder="Attendence Percentage (1-100)" type="number"
						tabindex="3" min=1 max=100 name="attendence" required>
					<p id="errorMessageforattendence"></p>
				</fieldset>
				<fieldset>
					<input placeholder="Class Rank" type="number" tabindex="4"
						name="classrank" required>
					<p id="errorMessageforclassrank"></p>
				</fieldset>
				<fieldset>
					<input placeholder="Enter Student Login Password" type="password"
						tabindex="5" name="password" id="password"
						onchange="return checkPassword(this)" required>
					<p id="errorMessageforpassword"></p>
				</fieldset>
				<fieldset>
					<button name="submit" type="submit" id="educational-submit">Register</button>
				</fieldset>
			</form>
		</div>



	</center>
     <%@include file="footer.jsp" %>
</body>
</html>