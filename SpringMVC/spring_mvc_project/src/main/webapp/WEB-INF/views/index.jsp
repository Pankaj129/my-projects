<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Spring JSP Tag Library -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home | Spring MVC App</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            text-align: center;
            margin-top: 100px;
        }
        .container {
            background-color: #ffffff;
            padding: 30px;
            margin: auto;
            width: 400px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333;
        }
        .login-link {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
        }
        .login-link:hover {
            background-color: #0056b3;
        }
        .timestamp {
            color: #666;
            font-size: 14px;
        }
    </style>
</head>

<body>
    <div class="container">
        <h2>Welcome to Spring MVC</h2>
        
        <p class="timestamp">
            Server Time: ${requestScope.latset_date}
        </p>

        <a class="login-link" href="<spring:url value='/user/login'/>">
            User Login
        </a>
    </div>
</body>
</html>