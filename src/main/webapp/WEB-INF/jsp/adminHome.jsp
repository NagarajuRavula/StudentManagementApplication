<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Home</title>
<link rel="stylesheet" href="/css/adminHomePage.css">
</head>
<body>
	<script src=${pageContext.request.contextPath}/js/adminHome.js></script>


	<center>
		<div class="header">
			<h2>Student Management Application</h2>

		</div>
		<a id="logout" href="/logout" > Log out<i class="fa fa-sign-out"></i></a>
		<h1>Welcome Admin</h1>
		<a href=${pageContext.request.contextPath}/jsp/studentPersonalDetails.jsp>Add Student+</a><br> <br>
		<h3>Students List</h3>
	</center>

	<div>

		<p id="deleteMessage">
	</div>

	<div class="tableDiv">
		<table border='1' width='100%'>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Father Name</th>
				<th>Email</th>
				<th>Gender</th>
				<th>Father</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

				<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.getId()}</td>
					<td>${student.getName()}</td>
					<td>${student.getFatherName()}</td>
					<td>${student.getEmail()}</td>
					<td>${student.getGender()}</td>
					<td>${student.getFatherName()}</td>
					<td><a href='/editStudentDetails?email=${student.getEmail()}'>View/Edit</a></td>
				<td><a href='./delete?id=${student.getId()}'>delete</a></td>
				</tr>
			   </c:forEach>
			
			
			

		</table>
	</div>




	<%!String message = "";%>
	<%
		message = (String) request.getAttribute("deleteMessage");
	%>
	<%
		if (message != null) {
	%>
	<div class="alert">
		<span class="closebtn">&times;</span>
		<%=message%>
	</div>
	<%
		}
	%>


	<script type="text/javascript">
		var close = document.getElementsByClassName("closebtn");
		var i;
		console.log(close);
		console.log(close.length);
		for (i = 0; i < close.length; i++) {
			close[i].onclick = function() {
				var div = this.parentElement;
				console.log(div);
				div.style.opacity = "0";
				setTimeout(function() {
					div.style.display = "none";
				}, 600);
			}
		}
	</script>

</body>
</html>