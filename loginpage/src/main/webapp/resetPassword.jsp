<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Reset Password</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .reset-form { margin: auto; padding: 2em; max-width: 300px; }
        input[type="password"] {
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
    <div class="reset-form">
        <h2>Reset Password</h2>
        <form action="ResetPasswordServlet" method="post">
            <input type="password" name="newPassword" placeholder="New Password" required /><br />
            <input type="password" name="confirmPassword" placeholder="Confirm New Password" required /><br />
            <input type="submit" value="Reset Password" />
        </form>
    </div>
</body>
</html>
