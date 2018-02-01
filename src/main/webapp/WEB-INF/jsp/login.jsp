<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet"
	href=${pageContext.request.contextPath}/css/loginPage.css>
</head>
<body>
	<script src=${pageContext.request.contextPath}/js/loginValidations.js></script>
	<center>
		<div class="header">
			<h2>Student Management Application</h2>

			<h3>please Login to continue....</h3>
		</div>
		<c:if test="${not empty errorMessage}">
			<p>Error: ${errorMessage}</p>
		</c:if>

	</center>



	<div class="login-page">
		<div class="form">
			<form class="login-form"
				action=${pageContext.request.contextPath}/authenticate method="post"
				onsubmit="return validateLoginForm()">
				<input type="email" placeholder="email" name="email" id="name" tabindex="1"
					required /> <input type="password" placeholder="password" tabindex="2"
					name="password" id="password" onchange=" return checkPassword(this)"
					required />
				<p id="errorMessageforpassword"></p>
				<button >login</button>
			</form>
		</div>
	</div>
</body>
</html>