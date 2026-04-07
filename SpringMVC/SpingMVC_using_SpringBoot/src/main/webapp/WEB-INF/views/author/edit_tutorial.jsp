<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Tutorial</title>

<style>
body {
	font-family: Arial, sans-serif;
	background: #f4f6f9;
	margin: 0;
}

.container {
	width: 45%;
	margin: 50px auto;
	background: #fff;
	padding: 30px;
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
	margin-top: 12px;
	display: block;
	color: #444;
}

input, textarea, select {
	width: 100%;
	padding: 10px;
	margin-top: 6px;
	border-radius: 6px;
	border: 1px solid #ccc;
	font-size: 14px;
}

textarea {
	height: 120px;
	resize: vertical;
}

input:focus, textarea:focus, select:focus {
	outline: none;
	border-color: #0dcaf0;
	box-shadow: 0 0 5px rgba(13, 202, 240, 0.5);
}

.btn {
	width: 100%;
	margin-top: 20px;
	padding: 12px;
	background: #ffc107;
	color: #000;
	border: none;
	border-radius: 8px;
	font-size: 16px;
	cursor: pointer;
	transition: 0.3s ease;
}

.btn:hover {
	background: #e0a800;
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

.msg {
	background: #d1ecf1;
	color: #0c5460;
	padding: 10px;
	border-radius: 6px;
	margin-bottom: 15px;
	text-align: center;
}
</style>

</head>

<body>

	<div class="container">

		<!-- Back -->
		<div class="top-link">
			<c:url var="dashboardUrl" value="/author/dashboard" />
			<a href="${dashboardUrl}">← Back to Dashboard</a>
		</div>

		<h2>✏️ Edit Tutorial</h2>

		<!-- Message -->
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form:form method="post" modelAttribute="tutorial">

			<!-- Hidden ID -->
			<form:hidden path="id" />

			<label>Title</label>
			<form:input path="tutorialName" placeholder="Enter tutorial title" />
			<form:errors path="tutorialName" cssClass="error" />

			<label>Publish Date</label>
			<form:input path="publishDate" type="date" />
			<form:errors path="publishDate" cssClass="error" />

			<label>Content</label>
			<form:textarea path="content"
				placeholder="Update tutorial content..." />
			<form:errors path="content" cssClass="error" />

			<label>Topic</label>
			<form:select path="selectedTopic.id">
				<form:option value="">-- Select Topic --</form:option>
				<c:forEach var="t" items="${topics}">
					<form:option value="${t.id}">${t.topicName}</form:option>
				</c:forEach>
			</form:select>
			<form:errors path="selectedTopic" cssClass="error" />

			<button type="submit" class="btn">💾 Update Tutorial</button>

		</form:form>

	</div>

</body>
</html>