<%@page import="com.royal.bean.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>Emp ID</td>
			<td>Emp Name</td>
			<td>Dept ID</td>
			<td>DOJ</td>
			<td>Salary</td>
		</tr>
		
		<%
			ArrayList<EmployeeBean> elist = (ArrayList<EmployeeBean>)session.getAttribute("list");
			for(int i = 0; i < elist.size(); i++) {
				EmployeeBean e = elist.get(i);
		%>
			<tr>
				<td><%= e.getEmp_id() %></td>
				<td><%= e.getEmp_name() %></td>
				<td><%= e.getDept_id() %></td>
				<td><%= e.getDoj() %></td>
				<td><%= e.getSalary() %></td>
				<td><a href='UpdateServlet?id=<%=e.getEmp_id()%>'>EDIT</a> | <a href='DeleteServlet?id=<%=e.getEmp_id()%>'>Update</a></td>
			</tr>
		
		
	</table>
s
</body>
</html>