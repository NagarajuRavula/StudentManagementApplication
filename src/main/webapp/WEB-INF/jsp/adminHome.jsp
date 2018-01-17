<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Home</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/css/adminHomePage.css>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<script src=${pageContext.request.contextPath}/js/adminHome.js></script>


	<center>
		<div class="header">
			<h2>Student Management Application</h2>
		</div>

		<p id="logedInName">
			Logged in As: <b id="email">${admin.getEmail()}</b>
		</p>
		<a id="logout" href=${pageContext.request.contextPath}/logout> Log
			out<i class="fa fa-sign-out"></i>
		</a>
		<h2>welcome ${admin.getName()}</h2>

		<a href=${pageContext.request.contextPath}/addStudent>Add Student+</a><br>
		<br>
		<h3>Students List</h3>
	</center>

	<div class="tableDiv" id="tableDiv">
		<table border='1' width='100%' id="table1">
			<tr id="row1">
				<th>Id</th>
				<th>Name</th>
				<th>Father Name</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</table>
	</div>


</body>
</html>