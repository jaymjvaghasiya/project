<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Forgot Password</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .forgot-form { margin: auto; padding: 2em; max-width: 300px; }
        input[type="email"] {
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
    </style>
</head>
<body>
    <div class="forgot-form">
        <h2>Forgot Password</h2>
        <form action="ForgotPasswordServlet" method="post">
            <input type="email" name="email" placeholder="Enter your email" required /><br />
            <input type="submit" value="Submit" />
        </form>
    </div>
</body>
</html>
