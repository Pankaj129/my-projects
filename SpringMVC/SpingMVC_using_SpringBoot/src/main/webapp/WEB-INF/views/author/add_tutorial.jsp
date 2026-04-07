<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Tutorial</title>

<style>
body {
	font-family: Arial, sans-serif;
	background: #f4f6f9;
	margin: 0;
	padding: 0;
}

.container {
	width: 40%;
	margin: 50px auto;
	background: white;
	padding: 25px 30px;
	border-radius: 12px;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	margin-bottom: 20px;
	color: #333;
}

label {
	font-weight: bold;
	display: block;
	margin-top: 10px;
	color: #444;
}

input, textarea, select {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	border-radius: 6px;
	border: 1px solid #ccc;
	font-size: 14px;
}

textarea {
	resize: vertical;
	height: 100px;
}

input:focus, textarea:focus, select:focus {
	outline: none;
	border-color: #0dcaf0;
	box-shadow: 0 0 5px rgba(13, 202, 240, 0.5);
}

.btn {
	width: 100%;
	background: #0dcaf0;
	color: white;
	padding: 12px;
	border: none;
	margin-top: 20px;
	font-size: 16px;
	border-radius: 8px;
	cursor: pointer;
	transition: 0.3s ease;
}

.btn:hover {
	background: #0bbcd6;
	transform: translateY(-1px);
}

.top-link {
	text-align: right;
	margin-bottom: 10px;
}

.top-link a {
	text-decoration: none;
	color: #0dcaf0;
	font-weight: bold;
}

.top-link a:hover {
	text-decoration: underline;
}

.error {
	color: red;
	font-size: 12px;
}
</style>

</head>

<body>

	<div class="container">

		<!-- Back Link -->
		<div class="top-link">
			<c:url var="dashboardUrl" value="/author/dashboard" />
			<a href="${dashboardUrl}">← Back to Dashboard</a>
		</div>

		<h2>📘 Add New Tutorial</h2>

		<form:form method="post" modelAttribute="tutorial">

			<label>Title</label>
			<form:input path="tutorialName" placeholder="Enter tutorial title" />
			<form:errors path="tutorialName" cssClass="error" />

			<label>Publish Date</label>
			<form:input path="publishDate" type="date" />
			<form:errors path="publishDate" cssClass="error" />

			<label>Content</label>
			<form:textarea path="content"
				placeholder="Write tutorial content here..." />
			<form:errors path="content" cssClass="error" />

			<label>Topic</label>
			<form:select path="selectedTopic.id">
				<form:option value="">-- Select Topic --</form:option>
				<c:forEach var="t" items="${topics}">
					<form:option value="${t.id}">${t.topicName}</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="selectedTopic" cssClass="error" />

			<button type="submit" class="btn">➕ Add Tutorial</button>

		</form:form>

	</div>

</body>
</html>