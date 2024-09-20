<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Employee Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .form-container {
        background-color: #fff;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2);
        width: 350px;
    }
    h1 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }
    label {
        font-weight: bold;
        color: #555;
        display: block;
        margin-bottom: 8px;
    }
    input[type="text"], input[type="date"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
    }
    input[type="submit"] {
        width: 100%;
        padding: 12px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>

    <div class="form-container">
        <h1>Fill up the form</h1>
        <form action="InsertServlet" method="post">
            
            <label for="id">Employee ID:</label>
            <input type="text" name="id" id="id" required> 
            
            <label for="name">Employee Name:</label>
            <input type="text" name="name" id="name" required> 
            
            <label for="did">Department ID:</label>
            <input type="text" name="did" id="did" required> 
            
            <label for="doj">Employee DOJ:</label>
            <input type="date" name="doj" id="doj" required> 
            
            <label for="salary">Employee Salary:</label>
            <input type="text" name="salary" id="salary" required> 
            
            <input type="submit" value="Submit">
            
        </form>
    </div>

</body>
</html>
