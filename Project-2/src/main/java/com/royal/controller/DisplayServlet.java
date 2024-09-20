package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;
import com.royal.bean.EmployeeBean;
import com.royal.dao.EmployeeDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Fetch employee list from DAO
		EmployeeDao ed = new EmployeeDao();
		ArrayList<EmployeeBean> el = ed.displayAllEmployees();

		// Set employee list as an attribute for the request
		request.setAttribute("employeeList", el);

		// Forward the request to the JSP page
		request.getRequestDispatcher("displaydata.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
