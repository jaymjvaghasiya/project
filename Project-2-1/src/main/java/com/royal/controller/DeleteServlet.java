package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.dao.EmployeeDao;

import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		int id = Integer.parseInt(request.getParameter("id"));
		EmployeeDao ed = new EmployeeDao();
		int rows = ed.deleteQry(id);
		
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
