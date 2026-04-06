<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>

<style>
body {
	font-family: Arial;
	background: #f8f9fa;
	margin: 0;
	padding: 0;
}

.container {
	width: 60%;
	margin: 100px auto;
	text-align: center;
	background: white;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0px 0px 15px #ccc;
}

h1 {
	color: #dc3545;
	font-size: 40px;
}

.msg {
	font-size: 18px;
	color: #333;
	margin: 20px 0;
}

.btn {
	display: inline-block;
	margin: 10px;
	padding: 10px 20px;
	text-decoration: none;
	border-radius: 5px;
	color: white;
}

.home {
	background: #28a745;
}

.login {
	background: #007bff;
}
</style>

</head>
<body>

	<div class="container">

		<h1>⚠️ Oops!</h1>

		<!-- ERROR MESSAGE FROM CONTROLLER -->
		<p class="msg">
			<c:choose>
				<c:when test="${not empty errorMessage}">
				${errorMessage}
			</c:when>
				<c:otherwise>
				Something went wrong. Please try again later.
			</c:otherwise>
			</c:choose>
		</p>

		<!-- OPTIONAL TECHNICAL DETAILS (ONLY FOR DEV) -->
		<c:if test="${not empty exception}">
			<details>
				<summary>Technical Details</summary>
				<pre>${exception}</pre>
			</details>
		</c:if>

		<!-- NAVIGATION BUTTONS -->
		<a class="btn home" href="<spring:url value='/'/>">Go to Home</a> <a
			class="btn login" href="<spring:url value='/users/login'/>">Login
			Again</a>

	</div>

</body>
</html>