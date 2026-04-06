<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tutorial Details</title>

    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            width: 60%;
            margin: 50px auto;
            text-align: center;
        }

        .box {
            background-color: #f2f2f2;
            padding: 20px;
            border-radius: 10px;
            margin-top: 20px;
        }

        a {
            display: inline-block;
            margin: 10px;
            text-decoration: none;
            color: #ffffff;
            background-color: #007bff;
            padding: 8px 14px;
            border-radius: 5px;
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

        h3 {
            color: #333;
        }
    </style>

</head>

<body>

<div class="container">

    <h3>Tutorial Details</h3>

    <div class="box">

        <h4>Selected Tutorial Contents</h4>
        <p>${tutorial_details}</p>

        <spring:url var="backUrl"
                    value="/customer/tutorials?topicId=${requestScope.tutorial_details.selectedTopic.id}" />

        <spring:url var="logoutUrl" value="/user/logout" />

        <a href="${backUrl}">⬅ Back</a>

        <a href="${logoutUrl}" class="logout">Logout</a>

    </div>

</div>

</body>
</html>