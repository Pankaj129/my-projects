<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logout</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        .container {
            width: 50%;
            margin: 80px auto;
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
    </style>

</head>

<body>

<div class="container">

    <h3>
        Hello, <span class="highlight">${requestScope.user_dtls.firstname}</span>
    </h3>

    <p class="msg">You have logged out...</p>

    <p class="msg">You will be automatically redirected to the home page shortly...</p>

</div>

</body>
</html>