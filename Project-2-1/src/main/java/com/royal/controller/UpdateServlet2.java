package com.royal.controller;

import java.io.IOException;

import com.royal.bean.EmployeeBean;
import com.royal.dao.EmployeeDao;

import jakarta.servlet.http.*;
import jakarta.servlet.*;

public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int id = Integer.parseInt((String)request.getAttribute("Emp_id"));
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int did = Integer.parseInt(request.getParameter("did"));
		String doj = request.getParameter("doj");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		EmployeeBean ebean = new EmployeeBean(id, name, did, doj, salary);
		EmployeeDao ed = new EmployeeDao();
		int rows = ed.updateQry(ebean, id);
		
		if(rows > 0) {
			request.getRequestDispatcher("DisplayServlet").forward(request, response);;
		} else {
			System.out.println("Error occured.");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
