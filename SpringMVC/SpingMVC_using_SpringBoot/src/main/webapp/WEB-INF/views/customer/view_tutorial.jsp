<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${tutorial.tutorialName}</title>

<!-- Bootstrap CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet" href="<c:url value='/css/view_tutorial.css'/>">

</head>

<body>
	<div class="d-flex justify-content-end mt-3 me-3">
		<button class="btn btn-dark btn-sm" onclick="toggleDarkMode()">
			🌙 Dark Mode</button>
	</div>

	<div class="container mt-4">

		<!-- Card -->
		<div class="card tutorial-card shadow-lg">

			<!-- HEADER -->
			<div class="tutorial-header">

				<h2 class="mb-2">${tutorial.tutorialName}</h2>

				<span class="badge bg-light text-dark meta-badge"> 📚
					${tutorial.selectedTopic.topicName} </span> <span
					class="badge bg-warning text-dark meta-badge"> 🔥
					${tutorial.visits} Views </span> <span class="badge bg-success meta-badge">
					📅 ${tutorial.publishDate} </span>

			</div>

			<!-- BODY -->
			<div class="card-body">

				<!-- AUTHOR -->
				<div class="author-box mb-3">
					👨‍🏫 <b>Author:</b> ${tutorial.author.firstname}
				</div>

				<hr />

				<!-- CONTENT -->
				<div class="content-box">${tutorial.content}</div>

				<hr />

				<!-- ACTIONS -->
				<div class="d-flex justify-content-between">

					<c:url var="dashboardUrl" value="/customer/dashboard" />
					<a href="${dashboardUrl}" class="btn btn-secondary">⬅ Back</a>

					<button class="btn btn-outline-primary" onclick="window.print()">
						🖨 Print</button>

				</div>

			</div>
		</div>

	</div>
	<script src="<c:url value='/js/view_tutorial.js'/>"></script>
</body>
</html>