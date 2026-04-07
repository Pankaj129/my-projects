<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Author Dashboard</title>

<style>
body {
	font-family: Arial;
	background-color: #f4f6f9;
	margin: 0;
}

.navbar {
	background-color: #343a40;
	color: white;
	padding: 15px;
	display: flex;
	justify-content: space-between;
}

.container {
	width: 85%;
	margin: 30px auto;
	background: white;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px #ccc;
}

.btn {
	background: #0dcaf0;
	color: white;
	padding: 6px 10px;
	border-radius: 5px;
	text-decoration: none;
	font-size: 13px;
}

.btn-danger {
	background: red;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid #ddd;
	padding: 10px;
}

th {
	background: #f2f2f2;
}
</style>

</head>

<body>

	<div class="navbar">
		<div>Welcome, ${user.firstname} 👋</div>

		<c:url var="logoutUrl" value="/users/logout" />

		<form action="${logoutUrl}" method="post" style="display: inline;">

			<button type="submit"
				style="background: red; border: none; color: white; cursor: pointer;"
				onclick="return confirm('Are you sure you want to logout?');">
				Logout</button>
		</form>
	</div>

	<div class="container">
		<!-- Success -->
		<c:if test="${not empty msg}">
		    <div class="success-box">${msg}</div>
		</c:if>
		
		<!-- Error -->
		<c:if test="${not empty error}">
		    <div class="error-box">${error}</div>
		</c:if>

		<h2>Your Tutorials</h2>

		<c:url var="addUrl" value="/author/tutorials/add"/>
		<a href="${addUrl}" class="btn">➕ Add Tutorial</a>

		<c:if test="${empty tutorials}">
			<p>No tutorials available.</p>
		</c:if>

		<c:if test="${not empty tutorials}">
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Publish Date</th>
						<th>Visits</th>
						<th>Topic</th>
						<th>Content</th>
						<th>Actions</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="t" items="${tutorials}">
						<tr>
							<td>${t.id}</td>
							<td>${t.tutorialName}</td>
							<td>${t.publishDate}</td>
							<td>${t.visits}</td>

							<!-- Avoid Lazy Load Exception -->
							<td>${t.selectedTopic.topicName}</td>

							<td>
								<c:choose>
									<c:when test="${fn:length(t.content) > 50}">
										${fn:substring(t.content, 0, 50)}...
									</c:when>
									<c:otherwise>
										${t.content}
									</c:otherwise>
								</c:choose>
							</td>

							<td>
								<c:url var="editUrl" value="/author/tutorials/edit/${t.id}"/>
								<c:url var="deleteUrl" value="/author/tutorials/delete/${t.id}"/>

								<a href="${editUrl}" class="btn">Edit</a>
								<a href="${deleteUrl}" class="btn btn-danger"
								   onclick="return confirm('Are you sure you want to delete this tutorial?')">🗑 Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

	</div>

</body>
</html>