<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.royal.bean.EmployeeBean" %>
<%
    // Retrieve employee list from the request attribute
    ArrayList<EmployeeBean> employeeList = (ArrayList<EmployeeBean>) request.getAttribute("employeeList");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        a {
            color: #4CAF50;
            text-decoration: none;
            font-weight: bold;
        }
        a:hover {
            text-decoration: underline;
        }
        .action-links {
            display: flex;
            gap: 10px;
        }
        .button {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            text-decoration: none;
            font-weight: bold;
            cursor: pointer;
            margin-right: 10px;
        }
        .button:hover {
            background-color: #45a049;
        }
        .button-container {
            margin-top: 20px;
            display: flex;
            gap: 20px;
        }
    </style>
    
</head>
<body>
    <h2>Employee List</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department ID</th>
            <th>DOJ</th>
            <th>Salary</th>
            <th>Gujarati Name</th>
            <th>Action</th>
        </tr>
        <%
            if (employeeList != null) {
                for (EmployeeBean ebean : employeeList) {
        %>
        <tr>
            <td><%= ebean.getEmpId() %></td>
            <td><%= ebean.getEmpName() %></td>
            <td><%= ebean.getDeptId() %></td>
            <td><%= ebean.getDoj() %></td>
            <td><%= ebean.getSalary() %></td>
            <td><%= ebean.getGujaratiName() %></td>
            <td>
                <div class="action-links">
                    <a href="DeleteServlet?id=<%= ebean.getEmpId() %>">Delete</a>
                    <a href="UpdateServlet?id=<%= ebean.getEmpId() %>">Update</a>
                </div>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>

    <!-- Create a container for the buttons with proper spacing -->
    <div class="button-container">
        <a class="button" href="Insert.jsp">Insert New Employee</a>
        <a class="button" href="logout">Logout</a>
        <a class="button" href="PDFGeneratorServlet">Download PDF</a>
    </div>

</body>
</html>
