<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
    int id = Integer.parseInt((String) request.getAttribute("Emp_id"));
%>

	
	<form action="UpdateServlet" method="post">
		ID: <input type='text' value=<%= id %>>
		<h3>Enter new values</h3>
		
		Employee Name: <input type='text' name='name'> <br>
		Department id: <input type='text' name='name'> <br>
		Employee DOJ: <input type='date' name='doj'> <br>
		Employee Salary: <input type='text' name='salary'> <br>
		
		<input type="submit">
		
	</form>
</body>
</html>