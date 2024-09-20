<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gujarati Data</title>
</head>
<body>
<%
    try {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a database connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testapp", "root", "");

        // Create a statement object
        Statement stmt = conn.createStatement();

        // Execute the query
        ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

        // Iterate over the result set and display the data
        while (rs.next()) {
            String gujaratiData = rs.getString("gujaratiName");
            out.println(gujaratiData + "<br>");
            System.out.println(gujaratiData);
        }

        // Close the result set, statement, and connection
        rs.close();
        stmt.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
%>
</body>
</html>