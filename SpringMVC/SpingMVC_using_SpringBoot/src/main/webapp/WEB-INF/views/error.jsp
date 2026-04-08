<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>

<link rel="stylesheet" href="<c:url value='/css/error.css'/>">

</head>
<body>

	<div class="container">

		<h1>⚠️ Oops!</h1>

		<!-- ERROR MESSAGE FROM CONTROLLER -->
		<p class="msg">
			<c:choose>
				<c:when test="${not empty errorMessage}">
				${errorMessage}
			</c:when>
				<c:otherwise>
				Something went wrong. Please try again later.
			</c:otherwise>
			</c:choose>
		</p>

		<!-- OPTIONAL TECHNICAL DETAILS (ONLY FOR DEV) -->
		<c:if test="${not empty exception}">
			<details>
				<summary>Technical Details</summary>
				<pre>${exception}</pre>
			</details>
		</c:if>

		<!-- NAVIGATION BUTTONS -->
		<a class="btn home" href="<spring:url value='/'/>">Go to Home</a> <a
			class="btn login" href="<spring:url value='/users/login'/>">Login
			Again</a>

	</div>

</body>
</html>