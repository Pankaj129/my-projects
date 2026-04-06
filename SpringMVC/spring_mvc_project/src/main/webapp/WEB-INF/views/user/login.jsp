<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<style>
body {
	font-family: Arial, sans-serif;
	background: linear-gradient(to right, #74ebd5, #9face6);
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 0;
}

.login-container {
	background-color: #ffffff;
	padding: 30px 40px;
	border-radius: 10px;
	box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
	width: 350px;
}

h2 {
	text-align: center;
	margin-bottom: 20px;
	color: #333;
}

.error-msg {
	color: red;
	text-align: center;
	margin-bottom: 15px;
}

.form-group {
	margin-bottom: 15px;
}

label {
	display: block;
	margin-bottom: 5px;
	color: #555;
}

input[type="email"], input[type="password"] {
	width: 100%;
	padding: 8px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #4CAF50;
	border: none;
	color: white;
	font-size: 16px;
	border-radius: 5px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>

</head>

<body>

	<div class="login-container">

		<h2>User Login</h2>

		<!-- Error Message -->
		<div class="error-msg">${requestScope.mesg}</div>

		<form method="post">

			<div class="form-group">
				<label>Enter Email</label> <input type="email" name="email" required />
			</div>

			<div class="form-group">
				<label>Enter Password</label> <input type="password" name="pass"
					required />
			</div>

			<input type="submit" value="Login" />

		</form>

	</div>

</body>
</html>