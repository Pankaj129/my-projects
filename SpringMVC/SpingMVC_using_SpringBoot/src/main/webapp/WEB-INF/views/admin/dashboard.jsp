<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<style>
body {
	font-family: Arial;
	margin: 20px;
}

.card {
	display: inline-block;
	padding: 15px;
	margin: 10px;
	border-radius: 8px;
	background: #f2f2f2;
	width: 200px;
	text-align: center;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: center;
}

th {
	background: #333;
	color: white;
}

.btn {
	padding: 5px 10px;
	text-decoration: none;
	border-radius: 5px;
}

.view {
	background: green;
	color: white;
}

.edit {
	background: orange;
	color: white;
}

.delete {
	background: red;
	color: white;
}

.add {
    background: blue;
    color: white;
}
</style>

</head>
<body>

	<h2>👑 Admin Dashboard</h2>
	<!-- ================= ADD USER BUTTON ================= -->
	<div style="margin-bottom: 15px;">
		<a href="<spring:url value='/admin/users/add'/>"
			style="
				background: #007bff; 
				color: white; 
				padding: 10px 15px; 
				text-decoration: none; 
				border-radius: 5px; 
				display: inline-block;">
			➕ Add User </a>
	</div>

	<!-- ================= SUMMARY CARDS ================= -->
	<div class="card">
		<h3>Total Users</h3>
		<h2>${totalUsers}</h2>
	</div>

	<div class="card">
		<h3>Admins</h3>
		<h2>${adminCount}</h2>
	</div>

	<div class="card">
		<h3>Authors</h3>
		<h2>${authorCount}</h2>
	</div>

	<div class="card">
		<h3>Customers</h3>
		<h2>${customerCount}</h2>
	</div>

	<hr />

	<!-- ================= USERS TABLE ================= -->
	<h3>All Users</h3>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Role</th>
			<th>Actions</th>
		</tr>

		<c:forEach var="u" items="${users}">
			<tr>
				<td>${u.id}</td>
				<td>${u.name}</td>
				<td>${u.email}</td>
				<td>${u.role}</td>
				<td><a class="btn view"
					href="<spring:url value='/admin/users/view/${u.id}'/>">View</a> 
					<a class="btn edit"
					href="<spring:url value='/admin/users/edit/${u.id}'/>">Edit</a> 
					<a class="btn delete"
					href="<spring:url value='/admin/users/delete/${u.id}'/>"
					onclick="return confirm('Are you sure?')">Delete</a>
				</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>