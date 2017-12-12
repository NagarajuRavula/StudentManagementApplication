<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.studentwebapplication.beanfactory.*"
	import="com.studentwebapplication.service.impl.*"
	import="com.studentwebapplication.service.*"
	import="java.io.FileInputStream" import="java.io.IOException"
	import="java.util.Properties"
	import="com.studentwebapplication.utils.ErrorProperties"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Education Details</title>
</head>
<link rel="stylesheet" href="/css/studentEducationDetailsPage.css">
<body>
<script src=${pageContext.request.contextPath}/js/studentDetailsValidation.js></script>
	<%!String message = "";%>
	<%
		StudentManagementService studentManagementService = (StudentManagementService) ObjectFactory
				.getInstance(StudentManagementServiceImpl.class);
		Properties props = ErrorProperties.getProperty();
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		boolean status = studentManagementService.isExistingStudent(email);
		if (status == true) {
			message = email + " " + props.getProperty("EXISTING_USER");

			request.setAttribute("message", message);

			RequestDispatcher rd = request.getRequestDispatcher("studentPersonalDetails.jsp");
			rd.forward(request, response);
		}
		String fatherName = request.getParameter("fatherName");
		String motherName = request.getParameter("motherName");
		String gender = request.getParameter("gender");
	%>

<html>
<body>
	<center>

		<div class="header">
			<h2>Student Management Application</h2>

		</div>
		<div class="container">
		     
			<form id="contact" action=${pageContext.request.contextPath}/save
				method="post">
				<h3>Student registration form</h3>
				<h4>Enter the student Educational data</h4>
				
<!-- 				 <p id="errorMessage">hiii</p> -->
 

				<input type='hidden' name='fatherName' value='<%=fatherName%>'>
				<input type='hidden' name='motherName' value='<%=motherName%>'>
				<input type='hidden' name='name' value='<%=name%>'> <input
					type='hidden' name='email' value='<%=email%>'> <input
					type='hidden' name='gender' value='<%=gender%>'>


				<fieldset>
					<input placeholder="Class Standard (1-10)" type="number"
						name="presentclass" min=1 max=10  tabindex="1" onmouseout="return checkNumber(this)" autofocus required>
						 <p id="errorMessageforpresentclass"></p>
				</fieldset>
				<fieldset>
					<input placeholder="Marks (1-600)" type="number" name="marks" tabindex="2"
						min=1 max=600 onmouseout="return checkNumber(this)" required>
						<p id="errorMessageformarks"></p>
				</fieldset>
				<fieldset>
					<input placeholder="Attendence Percentage (1-100)" type="number"
						tabindex="3" min=1 max=100 name="attendence" onmouseout="return checkNumber(this)" required>
						<p id="errorMessageforattendence"></p>
				</fieldset>
				<fieldset>
					<input placeholder="Class Rank" type="number" tabindex="4"
						name="classrank"  onmouseout="return checkNumber(this)" required>
						<p id="errorMessageforclassrank"></p>
				</fieldset>
				<fieldset>
					<input placeholder="Enter Student Login Password" type="password"
						tabindex="5" name="password" onmouseout="return checkPassword(this)" required>
						<p id="errorMessageforpassword"></p>
				</fieldset>
				<fieldset>
					<button name="submit" type="submit" id="educational-submit">Register</button>
				</fieldset>
			</form>
		</div>



	</center>

</body>
</html>