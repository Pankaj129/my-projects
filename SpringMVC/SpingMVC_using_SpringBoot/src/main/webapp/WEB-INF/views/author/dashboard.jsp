<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Author Dashboard</title>

<link rel="stylesheet" href="<c:url value='/css/style.css'/>">

</head>

<body>

	<div class="navbar">
		<div>Welcome, ${user.firstname} 👋</div>

		<c:url var="logoutUrl" value="/users/logout" />
		<form action="${logoutUrl}" method="post" style="margin:0;">
			<button type="submit"
				style="background: red; border: none; color: white; padding: 6px 12px; border-radius: 5px; cursor: pointer;"
				onclick="return confirm('Are you sure you want to logout?');">
				Logout
			</button>
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

		<div class="top-bar">
			<c:url var="addUrl" value="/author/tutorials/add"/>
		    <a href="${addUrl}" class="btn-modern">➕ Add Tutorial</a>
		
		    <c:url var="dashboardUrl" value="/author/dashboard"/>
		    <a href="${dashboardUrl}" class="btn back-btn">⬅ Back</a>
		</div>
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
							<td>${t.selectedTopic.topicName}</td>

							<td>
							    <button class="btn view-btn" onclick="showContent(this)"
									data-content="${fn:escapeXml(t.content)}">👁 View</button>
							</td>

							<td>
								<div class="actions">
									<c:url var="editUrl" value="/author/tutorials/edit/${t.id}"/>
									<c:url var="deleteUrl" value="/author/tutorials/delete/${t.id}"/>

									<a href="${editUrl}" class="btn edit">✏️ Edit</a>
									<a href="${deleteUrl}" class="btn delete"
									   onclick="return confirm('Are you sure you want to delete this tutorial?')">
									   🗑 Delete
									</a>
								</div>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div id="contentModal" class="modal">
			    <div class="modal-box">
			        <span class="close" onclick="closeModal()">&times;</span>
			        <h3>Tutorial Content</h3>
			        <p id="modalContent"></p>
			    </div>
			</div>
			
		</c:if>

	</div>

	<script src="<c:url value='/js/app.js'/>"></script>

</body>
</html>