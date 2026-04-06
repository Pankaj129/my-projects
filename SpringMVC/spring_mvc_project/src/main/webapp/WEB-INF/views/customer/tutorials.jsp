<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tutorials List</title>

<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	width: 60%;
	margin: 40px auto;
	text-align: center;
}

table {
	background-color: lightgrey;
	margin: 20px auto;
	padding: 10px;
	border-radius: 8px;
	border-collapse: collapse;
}

caption {
	font-weight: bold;
	margin-bottom: 10px;
}

td {
	padding: 10px;
}

a {
	text-decoration: none;
	color: #2c3e50;
	font-weight: bold;
}

a:hover {
	color: #007bff;
}
</style>

</head>

<body>

	<div class="container">

		<h3>Available Tutorials</h3>

		<table>

			<caption>Available Tutorials under Topic ID:
				${param.topicId}</caption>

			<c:forEach var="tut_name" items="${requestScope.tut_names}">
				<tr>
					<spring:url var="url"
						value="/customer/tutorial_detail?tutName=${tut_name}" />

					<td><a href="${url}">${tut_name}</a></td>
				</tr>
			</c:forEach>

		</table>

	</div>

</body>
</html>