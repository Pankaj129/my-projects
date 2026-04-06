<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Topics Page</title>

    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .container {
            width: 60%;
            margin: 40px auto;
            text-align: center;
        }

        .message {
            color: green;
        }

        .user-details {
            color: #333;
        }

        table {
            background-color: lightgrey;
            margin: 20px auto;
            padding: 10px;
            border-radius: 8px;
        }

        td {
            padding: 8px;
        }

        input[type="submit"] {
            padding: 6px 12px;
            cursor: pointer;
        }
    </style>

</head>

<body>

<div class="container">

    <h3>Topics Page</h3>

    <h4 class="message">${requestScope.mesg}</h4>

    <h4 class="user-details">
        User Details: ${sessionScope.user_dtls}
    </h4>

    <spring:url var="url" value="/customer/tutorials" />

    <form action="${url}" method="get">

        <table>
            <c:forEach var="topic" items="${requestScope.topics}">
                <tr>
                    <td>
                        <input type="radio" name="topicId"
                               value="${topic.id}" required />
                    </td>
                    <td>${topic.topicName}</td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="2">
                    <input type="submit" value="Choose Topic" />
                </td>
            </tr>
        </table>

    </form>

</div>

</body>
</html>