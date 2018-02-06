<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.student.app.dto.Student"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {margin:0;}

ul#nav_list {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
    position: fixed;
    top: 0;
    width: 100%;
  
}
div#nav{
  z-index: 1;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #4CAF50;
}

.active {
    background-color: #4CAF50;
}

a#logout1{
	margin-left: 630px;
}
.header{
	background-color: #ceb291;
	margin-left: 100px;
	margin-top: 50px;
    margin-right: 100px;
        height: 40px;
}
.header:hover{
	background: pink;
	
}
h2#title{
margin-left: 330px;
font-size: 30px;
}
</style>
</head>
<body>
 <% Student User=(Student)session.getAttribute("loggedInUser"); %>
 
<div id="nav">
  <ul id="nav_list">
  <li><a href= "${pageContext.request.contextPath}/adminHome">Home</a></li>
  <li><a href="${pageContext.request.contextPath}/addStudent">Add Student</a></li>
  <li><a href="${pageContext.request.contextPath}/editStudentDetails?email=<%=User.getEmail()%>">Profile</a></li>
  <li><a href="${pageContext.request.contextPath}/studentReport">Student Report</a></li>
  <li><a href="${pageContext.request.contextPath}/studentIssues">Student Issues</a></li>
  <li><a id="logout1"  href=${pageContext.request.contextPath}/logout>Logout <i class="fa fa-sign-out"></i></a></li>
</ul>
</div>
	<div class="header">
			<h2 id="title" >Student Management Application</h2>
		</div>
</body>
</html>