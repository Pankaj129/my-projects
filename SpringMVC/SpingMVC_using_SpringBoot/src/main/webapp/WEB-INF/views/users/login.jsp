<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>

<link rel="stylesheet" href="<c:url value='/css/login.css'/>">

</head>
<body>
	<c:if test="${not empty msg}">
		<div class="success-box">${msg}</div>
	</c:if>

	<div class="login-box">

		<h2>🔐 User Login</h2>

		<!-- ERROR MESSAGE -->
		<c:if test="${not empty errorMessage}">
			<p class="error">${errorMessage}</p>
		</c:if>

		<!-- LOGIN FORM -->
		<form action="<spring:url value='/users/login'/>" method="post">

			<label>Email : </label> 
			<input type="text" name="email" placeholder="Enter email" required /> 
			
			<label>Password : </label> 
			<input type="password" name="password" placeholder="Enter password" required />

			<button type="submit">Login</button>

		</form>

		<br />

		<p style="text-align: center;">
			<a href="<spring:url value='/'/>">Back to Home</a>
		</p>

	</div>

</body>
</html>