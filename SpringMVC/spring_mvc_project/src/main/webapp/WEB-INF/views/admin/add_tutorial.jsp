<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Tutorial</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f6f8;
}

.container {
	width: 60%;
	margin: 50px auto;
	background-color: #ffffff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

h3 {
	text-align: center;
	color: #333;
}

.error {
	color: red;
	text-align: center;
	font-weight: bold;
}

table {
	width: 100%;
	margin-top: 20px;
}

td {
	padding: 10px;
}

input, select, textarea {
	width: 100%;
	padding: 8px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

textarea {
	resize: none;
}

.btn {
	background-color: #007bff;
	color: white;
	padding: 10px 16px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.btn:hover {
	background-color: #0056b3;
}
</style>

</head>

<body>

	<div class="container">

		<h3>Add New Tutorial</h3>

		<p class="error">${requestScope.err_mesg}</p>

		<form:form method="post" modelAttribute="tutorial">

			<table>

				<tr>
					<td>Choose Topic</td>
					<td><select name="selectedTopic.id">
							<c:forEach var="topic" items="${requestScope.topic_list}">
								<option value="${topic.id}">${topic.topicName}</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td>Choose Author</td>
					<td><select name="author.id">
							<c:forEach var="auth" items="${requestScope.author_list}">
								<option value="${auth.id}">${auth.firstname}
									${auth.lastname}</option>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td>Tutorial Name</td>
					<td><form:input path="tutorialName" /></td>
				</tr>

				<tr>
					<td>Publish Date</td>
					<td><form:input type="date" path="publishDate" /></td>
				</tr>

				<tr>
					<td>Visits</td>
					<td><form:input type="number" path="visits" /></td>
				</tr>

				<tr>
					<td>Contents</td>
					<td><form:textarea rows="10" cols="30" path="content" /></td>
				</tr>

				<tr>
					<td colspan="2" style="text-align: center;"><input
						type="submit" class="btn" value="Add New Tutorial" /></td>
				</tr>

			</table>

		</form:form>

	</div>

</body>
</html>