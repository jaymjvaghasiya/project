package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.EmployeeBean;
import com.royal.dao.EmployeeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

/**
 * Servlet implementation class InsertServlet
 */
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws jakarta.servlet.ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int did = Integer.parseInt(request.getParameter("did"));
		String doj = request.getParameter("doj").toString();
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		
		EmployeeDao ed = new EmployeeDao();
		EmployeeBean eb = new EmployeeBean(id, name, did, doj, salary);
		int rows = ed.insertQry(eb);
	
		if(rows > 0) {
			request.getRequestDispatcher("DisplayServlet").forward(request, response);	
		} else {
			out.print("Some error occured");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
