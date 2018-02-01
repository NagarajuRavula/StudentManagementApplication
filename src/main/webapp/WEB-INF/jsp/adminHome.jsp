<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.student.app.dto.Student"
%>

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
<script src=${pageContext.request.contextPath}/js/adminHome.js>
	</script>
<!-- this script is used to initialize the context path	 -->
<script type="text/javascript">
         var contextPath='<%=request.getContextPath()%>';
	</script>


<!--  library for toastr -->
<script type="text/javascript"
	src="//cdn.jsdelivr.net/jquery/1/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<link
	href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css"
	rel="stylesheet">
</head>
<body>
  <%@include file="header.jsp" %>
  <% Student user=(Student)session.getAttribute("loggedInUser"); %>
	<center>
		<p id="logedInName">
			Logged in As: <b id="email"><%=user.getEmail() %></b>
		</p>
		<h2>welcome <%=user.getName() %></h2>
		<br>
		<h3>Students List</h3>
	</center>

	<div class="tableDiv" id="tableDiv">
		<table border='1' width='100%' id="table1">
			<tr id="row">
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



<!-- 	<button class="success btn btn-success" onclick="toast()">Success</button> -->

 <%@include file="footer.jsp" %>

</body>
</html>