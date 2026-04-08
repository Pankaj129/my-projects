<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<link rel="stylesheet" href="<c:url value='/css/admin_dashboard.css'/>">

</head>
<body>
	<!-- NAVBAR -->
	<div class="navbar">
		<div>Welcome, Admin 👋</div>

		<c:url var="logoutUrl" value="/users/logout" />
		<form action="${logoutUrl}" method="post" style="margin:0;">
			<button type="submit" class="btn-modern red"
				onclick="return confirm('Are you sure you want to logout?');">
				Logout
			</button>
		</form>
	</div>

	<h2>👑 Admin Dashboard</h2>
	<!-- ================= ADD USER BUTTON ================= -->
	<div style="margin-bottom: 15px;">
		<a href="<spring:url value='/admin/users/add'/>" class="btn-modern">
			<span class="icon">➕</span> <span>Add User</span>
		</a>
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
				<td>${u.firstname}</td>
				<td>${u.lastname}</td>
				<td>${u.email}</td>
				<td>${u.role}</td>
				<td><a class="btn view"
					href="<spring:url value='/admin/users/view/${u.id}'/>">View</a> <a
					class="btn edit"
					href="<spring:url value='/admin/users/edit/${u.id}'/>">Edit</a> <a
					class="btn delete"
					href="<spring:url value='/admin/users/delete/${u.id}'/>"
					onclick="return confirm('Are you sure?')">Delete</a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>