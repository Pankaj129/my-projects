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
	width: 125px;
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

.btn-modern {
    display: inline-flex;
    align-items: center;
    gap: 8px;

    background: linear-gradient(135deg, #0dcaf0, #5bc0de);
    color: #fff;

    padding: 10px 18px;
    font-size: 14px;
    font-weight: 500;

    border: none;
    border-radius: 30px;
    text-decoration: none;

    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
    transition: all 0.3s ease;

    position: relative;
    overflow: hidden;
}

/* Hover Effect */
.btn-modern:hover {
    transform: translateY(-2px) scale(1.02);
    box-shadow: 0 6px 14px rgba(0, 0, 0, 0.2);
    background: linear-gradient(135deg, #0bbcd6, #31b0d5);
}

/* Click Effect */
.btn-modern:active {
    transform: scale(0.96);
    box-shadow: 0 3px 8px rgba(0, 0, 0, 0.2);
}

/* Icon */
.btn-modern .icon {
    font-size: 16px;
}

/* Ripple Effect */
.btn-modern::after {
    content: "";
    position: absolute;
    width: 0;
    height: 0;
    background: rgba(255, 255, 255, 0.4);
    border-radius: 50%;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    transition: width 0.4s ease, height 0.4s ease;
}

.btn-modern:active::after {
    width: 200px;
    height: 200px;
}
</style>

</head>
<body>

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