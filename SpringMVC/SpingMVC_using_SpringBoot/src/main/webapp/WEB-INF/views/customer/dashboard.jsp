<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Dashboard</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background-color: #f4f6f9;
}

.card-hover:hover {
	transform: scale(1.02);
	transition: 0.2s;
}

/* Sticky right section */
.sticky-sidebar {
	position: sticky;
	top: 20px;
}

/* Trending card style */
.trend-card {
	border-left: 4px solid #dc3545;
}

.logout-btn {
    background: red;
    border: none;
    color: white;
    padding: 6px 12px;
    border-radius: 5px;
    cursor: pointer;
    transition: all 0.3s ease;
}

/* Hover effect */
.logout-btn:hover {
    background: darkred;
    transform: scale(1.05);
}

/* Optional: click effect */
.logout-btn:active {
    transform: scale(0.95);
}
</style>

</head>

<body>

	<!-- NAVBAR -->
	<nav class="navbar navbar-dark bg-dark px-3">
		<span class="navbar-brand"> Welcome, ${user.firstname} 👋 </span>

		<c:url var="logoutUrl" value="/users/logout" />
		<form action="${logoutUrl}" method="post" style="margin:0;">
			<button type="submit" class="logout-btn"
				onclick="return confirm('Are you sure you want to logout?');">
				Logout
			</button>
		</form>
	</nav>

	<div class="container mt-4">

		<h3 class="mb-3">📚 Explore Tutorials</h3>

		<!-- FILTER -->
		<c:url var="selectUrl" value="/customer/dashboard" />
		<form method="get" action="${selectUrl}" class="row mb-4">

			<div class="col-md-4">
				<select name="topicId" class="form-select"
					onchange="this.form.submit()">
					<option value="">-- All Topics --</option>

					<c:forEach var="t" items="${topics}">
						<option value="${t.id}"
							<c:if test="${t.id == selectedTopicId}">selected</c:if>>
							${t.topicName}</option>
					</c:forEach>
				</select>
			</div>

			<div class="col-md-2">
				<a href="${selectUrl}" class="btn btn-secondary w-100">
					Reset </a>
			</div>

		</form>

		<!-- MAIN LAYOUT -->
		<div class="row">

			<!-- LEFT SIDE (Tutorials) -->
			<div class="col-md-8">

				<c:if test="${empty tutorials}">
					<div class="alert alert-warning text-center">
						No tutorials found for selected topic.
					</div>
				</c:if>

				<div class="row">
					<c:forEach var="t" items="${tutorials}">
						
						<!-- 2 per row -->
						<div class="col-md-6 mb-3">

							<div class="card shadow-sm card-hover h-100">

								<div class="card-body">

									<h5 class="card-title text-primary">
										${t.tutorialName}
									</h5>

									<p class="mb-1">
										<b>Topic:</b> ${t.selectedTopic.topicName}
									</p>

									<p class="mb-1">
										<b>Published:</b> ${t.publishDate}
									</p>

									<span class="badge bg-success">
										🔥 ${t.visits} views
									</span>

									<br><br>

									<c:url var="viewUrl" value="/customer/tutorial/${t.id}" />
									<a href="${viewUrl}" class="btn btn-info btn-sm">
										📖 Read More
									</a>

								</div>

							</div>

						</div>

					</c:forEach>
				</div>

			</div>

			<!-- RIGHT SIDE (Trending) -->
			<div class="col-md-4">

				<div class="sticky-sidebar">

					<h5 class="text-danger mb-3">🏆 Top Trending</h5>

					<c:forEach var="t" items="${trendingTutorials}" varStatus="status">

						<div class="card trend-card shadow-sm mb-3">

							<div class="card-body">

								<!-- Ranking -->
								<c:choose>
									<c:when test="${status.index == 0}">
										<span class="badge bg-warning text-dark">🥇 #1</span>
									</c:when>
									<c:when test="${status.index == 1}">
										<span class="badge bg-secondary">🥈 #2</span>
									</c:when>
									<c:when test="${status.index == 2}">
										<span class="badge bg-danger">🥉 #3</span>
									</c:when>
									<c:otherwise>
										<span class="badge bg-dark">#${status.index + 1}</span>
									</c:otherwise>
								</c:choose>

								<h6 class="mt-2">${t.tutorialName}</h6>

								<p class="mb-1">
									<b>Topic:</b> ${t.selectedTopic.topicName}
								</p>

								<span class="badge bg-danger">
									🔥 ${t.visits} views
								</span>

								<br><br>

								<c:url var="viewUrl" value="/customer/tutorial/${t.id}" />
								<a href="${viewUrl}" class="btn btn-outline-danger btn-sm">
									View
								</a>

							</div>

						</div>

					</c:forEach>

				</div>

			</div>

		</div>

	</div>

</body>
</html>