<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .login-form { margin: auto; padding: 2em; max-width: 300px; }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            width: 100%;
        }
        a { text-decoration: none; color: #007BFF; }
    </style>
</head>
<body>
<% String error = request.getParameter("error"); %>
<% String reset = request.getParameter("reset"); %>
<% String passwordReset = request.getParameter("passwordReset"); %>

<% if ("1".equals(error)) { %>
    <p style="color: red;">Invalid username or password.</p>
<% } %>
<% if ("1".equals(reset)) { %>
    <p style="color: green;">Password reset link has been sent to your email.</p>
<% } %>
<% if ("1".equals(passwordReset)) { %>
    <p style="color: green;">Your password has been successfully reset. Please login.</p>
<% } %>

    <div class="login-form">
        <h2>Login</h2>
        <form action="LoginServlet" method="post">
            <input type="text" name="username" placeholder="Username" required /><br />
            <input type="password" name="password" placeholder="Password" required /><br />
            <input type="submit" value="Login" />
        </form>
        <p><a href="forgotPassword.jsp">Forgot Password?</a></p>
    </div>
</body>
</html>
