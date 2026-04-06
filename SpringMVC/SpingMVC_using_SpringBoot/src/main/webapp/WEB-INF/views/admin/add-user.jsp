<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>

<style>
body {
	font-family: Arial;
	background: #f4f6f9;
	margin: 0;
	padding: 0;
}

.container {
	width: 40%;
	margin: 50px auto;
	background: white;
	padding: 25px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px #ccc;
}

h2 {
	text-align: center;
	color: #333;
}

label {
	font-weight: bold;
}

input, select {
	width: 100%;
	padding: 8px;
	margin: 5px 0 15px 0;
}

.btn {
	width: 100%;
	background: #28a745;
	color: white;
	padding: 10px;
	border: none;
	cursor: pointer;
	font-size: 16px;
}

.btn:hover {
	background: #218838;
}

.error {
	color: red;
	font-size: 13px;
}

.msg {
	text-align: center;
	color: green;
	font-weight: bold;
}

.top-link {
	text-align: right;
	margin-bottom: 10px;
}
</style>

</head>

<body>

	<div class="container">

		<div class="top-link">
			<a href="/admin/users">← Back to Users</a>
		</div>

		<h2>Add New User</h2>

		<!-- Success Message -->
		<c:if test="${not empty msg}">
			<p class="msg">${msg}</p>
		</c:if>

		<!-- Form -->
		<form:form method="post" action="/admin/users/add"
			modelAttribute="user">

			<label>First Name</label>
			<form:input path="firstname" />
			<form:errors path="firstname" cssClass="error" />

			<label>Last Name</label>
			<form:input path="lastname" />
			<form:errors path="lastname" cssClass="error" />

			<label>Email</label>
			<form:input path="email" />
			<form:errors path="email" cssClass="error" />

			<label>Password</label>
			<form:password path="password" />
			<form:errors path="password" cssClass="error" />

			<label>Role</label>
			<form:select path="role">
				<form:option value="">-- Select Role --</form:option>
				<form:option value="ADMIN">ADMIN</form:option>
				<form:option value="AUTHOR">AUTHOR</form:option>
				<form:option value="CUSTOMER">CUSTOMER</form:option>
			</form:select>
			<form:errors path="role" cssClass="error" />

			<button type="submit" class="btn">Add User</button>

		</form:form>

	</div>

</body>
</html>