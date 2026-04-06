<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>

<style>
body {
	font-family: Arial;
	background: #f5f5f5;
}

.container {
	width: 40%;
	margin: 80px auto;
	background: white;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0px 0px 10px #ccc;
}

h2 {
	text-align: center;
}

.row {
	margin: 10px 0;
	font-size: 16px;
}

.label {
	font-weight: bold;
}

.btn {
	display: block;
	text-align: center;
	margin-top: 20px;
	padding: 10px;
	background: #007bff;
	color: white;
	text-decoration: none;
	border-radius: 5px;
}
</style>

</head>
<body>

	<div class="container">

		<h2>👤 User Details</h2>

		<div class="row">
			<span class="label">ID:</span> ${user.id}
		</div>

		<div class="row">
			<span class="label">Name:</span> ${user.firstname}
		</div>

		<div class="row">
			<span class="label">Email:</span> ${user.email}
		</div>

		<div class="row">
			<span class="label">Role:</span> ${user.role}
		</div>

		<!-- Optional fields -->
		<c:if test="${not empty user.status}">
			<div class="row">
				<span class="label">Status:</span> ${user.status}
			</div>
		</c:if>

		<a class="btn" href="<spring:url value='/admin/users'/>"> ⬅ Back
			to Dashboard </a>

	</div>

</body>
</html>