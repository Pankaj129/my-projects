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
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
        }

        .container {
            width: 60%;
            margin: 60px auto;
            text-align: center;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }

        h3 {
            color: #333;
        }

        .msg {
            color: #555;
            margin: 10px 0;
        }

        .highlight {
            color: #007bff;
            font-weight: bold;
        }

        .links {
            margin-top: 20px;
        }

        a {
            display: inline-block;
            margin: 10px;
            text-decoration: none;
            padding: 10px 16px;
            border-radius: 5px;
            color: #fff;
            background-color: #007bff;
        }

        a:hover {
            background-color: #0056b3;
        }

        .logout {
            background-color: #dc3545;
        }

        .logout:hover {
            background-color: #a71d2a;
        }
    </style>

</head>

<body>

<div class="container">

    <h3>Admin Dashboard</h3>

    <p class="msg">${requestScope.mesg}</p>

    <h4>
        Hello,
        <span class="highlight">
            ${sessionScope.user_dtls.firstname}
            ${sessionScope.user_dtls.lastname}
        </span>
    </h4>

    <div class="links">

        <a href="<spring:url value='/admin/add_new_tut'/>">
            ➕ Add New Tutorial
        </a>

        <a href="<spring:url value='/user/logout'/>" class="logout">
            🚪 Logout
        </a>

    </div>

</div>

</body>
</html>