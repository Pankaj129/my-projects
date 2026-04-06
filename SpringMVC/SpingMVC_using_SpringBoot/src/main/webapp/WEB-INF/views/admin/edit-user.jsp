<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>

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

input, select {
	width: 100%;
	padding: 10px;
	margin: 10px 0;
}

button {
	width: 100%;
	padding: 10px;
	background: orange;
	color: white;
	border: none;
}
</style>

</head>
<body>

	<div class="container">

		<h2>✏️ Edit User</h2>

		<form:form method="post" action="/admin/users/edit"
			modelAttribute="user">

			<form:hidden path="id" />

			<label>First Name</label>
			<form:input path="firstname" />
			<form:errors path="firstname" cssClass="error" />

			<label>Last Name</label>
			<form:input path="lastname" />
			<form:errors path="lastname" cssClass="error" />

			<label>Email</label>
			<form:input path="email" />
			<form:errors path="email" cssClass="error" />

			<label>Password (leave blank if not changing)</label>
			<form:password path="password" />

			<label>Role</label>
			<form:select path="role">
				<form:option value="ADMIN">ADMIN</form:option>
				<form:option value="AUTHOR">AUTHOR</form:option>
				<form:option value="CUSTOMER">CUSTOMER</form:option>
			</form:select>

			<button type="submit">Update</button>

		</form:form>

	</div>

</body>
</html>