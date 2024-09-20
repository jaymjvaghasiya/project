package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.EmployeeBean;
import com.royal.dao.EmployeeDao;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		int id = Integer.parseInt(request.getParameter("id"));
		EmployeeDao ed = new EmployeeDao();
		EmployeeBean eb = ed.displayOne(id);
		
		
		out.println("<html><head>");
		out.println("<title>Update Employee</title>");
		out.println("<style>");
		out.println("body { font-family: Arial, sans-serif; background-color: #f0f0f0; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
		out.println(".form-container { background-color: #fff; padding: 30px; border-radius: 10px; box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.2); width: 400px; }");
		out.println("h3 { color: #333; text-align: center; margin-bottom: 20px; }");
		out.println("label { font-weight: bold; color: #555; display: block; margin-bottom: 8px; }");
		out.println("input[type='text'], input[type='date'] { width: 100%; padding: 10px; margin-bottom: 15px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px; }");
		out.println("input[type='submit'] { width: 100%; padding: 12px; background-color: #4CAF50; color: white; border: none; border-radius: 5px; font-size: 16px; font-weight: bold; cursor: pointer; }");
		out.println("input[type='submit']:hover { background-color: #45a049; }");
		out.println("</style>");
		out.println("</head><body>");

		out.println("<div class='form-container'>");
		out.println("<h3>Enter New Values for Employee</h3>");
		out.println("<form action='UpdateServlet2' method='post'>");
		out.println("<label for='id'>ID:</label>");
		out.println("<input type='text' name='id' value='" + id + "' readonly>");  // Making ID readonly
		
		out.println("<label for='name'>Employee Name:</label>");
		out.println("<input type='text' name='name' value='"+eb.getEmpName()+"' required>");
		
		out.println("<label for='did'>Department ID:</label>");
		out.println("<input type='text' name='did' value='"+eb.getDeptId()+"' required>");
		
		out.println("<label for='doj'>Employee DOJ:</label>");
		out.println("<input type='date' name='doj' value='"+eb.getDoj()+"' required>");
		
		out.println("<label for='salary'>Employee Salary:</label>");
		out.println("<input type='text' name='salary' value='"+eb.getSalary()+"' required>");
		
		out.println("<input type='submit' value='Update'>");
		out.println("</form>");
		out.println("</div>");

		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
