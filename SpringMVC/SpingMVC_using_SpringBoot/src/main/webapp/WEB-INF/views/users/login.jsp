<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>

<style>
body {
	font-family: Arial;
	background: #f5f5f5;
}

.login-box {
	width: 400px;
	margin: 80px auto;
	padding: 15px;
	background: white;
	border-radius: 8px;
	box-shadow: 0px 0px 10px #ccc;
}

h2 {
	text-align: center;
}

input[type=text], input[type=password] {
	width: 90%;
	padding: 10px;
	margin: 8px 0;
}

button {
	width: 100%;
	padding: 10px;
	background: #28a745;
	color: white;
	border: none;
	cursor: pointer;
	align: center
}

button:hover {
	background: #218838;
}

.error {
	color: red;
	text-align: center;
}

</style>

</head>
<body>

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