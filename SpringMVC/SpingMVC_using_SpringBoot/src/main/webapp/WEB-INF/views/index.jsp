<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Spring JSP tag library -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>

<style>
body {
	font-family: Arial;
	text-align: center;
	margin-top: 60px;
	background-color: #f4f6f9;
}

.box {
	background: white;
	padding: 30px;
	width: 50%;
	margin: auto;
	border-radius: 10px;
	box-shadow: 0px 0px 10px #ccc;
}

a {
	display: inline-block;
	margin-top: 15px;
	padding: 10px 20px;
	background: #28a745;
	color: white;
	text-decoration: none;
	border-radius: 5px;
}

a:hover {
	background: #1e7e34;
}
</style>

</head>

<body>

	<div class="box">

		<!-- Welcome message -->
		<h2>Welcome to Spring MVC Boot Application 🚀</h2>

		<!-- Timestamp from controller -->
		<h4>Server Time: ${requestScope.ts}</h4>

		<hr />

		<!-- Spring URL tag usage -->
		<h4>
			<a href="<spring:url value='/users/login'/>">User Login</a>
		</h4>

	</div>

</body>
</html>