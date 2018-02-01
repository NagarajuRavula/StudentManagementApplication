<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.student.app.dto.Student"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Student Home</title>
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/css/studentHomePage.css>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	
	<script type="text/javascript" src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet">
	 <% Student user=(Student)session.getAttribute("loggedInUser"); %>
	
	<center>
		<div class="header">
			<h2>Student Management Application</h2>

		</div>

		<p id="logedInName">
			Logged in As: <b id="email"><%=user.getEmail() %></b>
		</p>
		<a id="logout" class="success btn btn-success" href=${pageContext.request.contextPath}/logout>
			Log out<i class="fa fa-sign-out"></i>
		</a>
		<h2>welcome <%=user.getName() %></h2>

		<h3>Profile Information</h3>

		<div class="tableDiv">
			<table border='1' width='100%'>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Father Name</th>
					<th>Email</th>
					<th>Gender</th>
					<th>View/Edit</th>
				</tr>
				<tr>
					<td><%=user.getId() %></td>
					<td><%=user.getName() %></td>
					<td><%=user.getFatherName() %></td>
					<td><%=user.getEmail() %></td>
					<td><%=user.getGender() %></td>
					<td><a id='edit_anchor' class="success btn btn-success"
						href=${pageContext.request.contextPath}/editStudentDetails?email=<%=user.getEmail() %>>View/Edit</a></td>
				</tr>
			</table>
		</div>


	</center>
</body>
</html>