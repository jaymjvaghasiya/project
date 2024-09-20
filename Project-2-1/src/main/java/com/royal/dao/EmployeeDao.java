package com.royal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.royal.bean.EmployeeBean;
import com.royal.util.DBConnection;

public class EmployeeDao {
	
	public int insertQry(EmployeeBean sbean) {
		String qry = "INSERT INTO employee (empId, empName, deptId, doj, salary) VALUES ('"+sbean.getEmpId()+"', '"+sbean.getEmpName()+"', '"+sbean.getDeptId()+"', '"+sbean.getDoj()+"', '"+sbean.getSalary()+"')";
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		int affectedRows = 0;
		
		if(conn != null) {
			try {
				stmt = conn.createStatement();
				affectedRows = stmt.executeUpdate(qry);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return affectedRows;
	}
	
	public int deleteQry(int id) {
		String qry = "delete from employee where empId =" + id;
		System.out.println(id);
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		int affectedRows = 0;
		
		if(conn != null) {
			try {
				stmt = conn.createStatement();
				affectedRows = stmt.executeUpdate(qry);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return affectedRows;
	}
	
	public int updateQry(EmployeeBean sbean, int id) {
		String qry = "update employee SET empName = '"+sbean.getEmpName()+"', deptId= '"+sbean.getDeptId()+"', doj = '"+sbean.getDoj()+"', salary = '"+sbean.getSalary()+"' where empId = " + id;
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		int affectedRows = 0;
		
		if(conn != null) {
			try {
				stmt = conn.createStatement();
				affectedRows = stmt.executeUpdate(qry);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return affectedRows;
	}
	
	public ArrayList<EmployeeBean> displayAllEmployees() {
		String qry = "Select * from Employee";
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet result = null;
		
		ArrayList<EmployeeBean> list = new ArrayList<EmployeeBean>();
		
		EmployeeBean e = null;
		
		if(conn != null) {
			try {
				stmt = conn.createStatement();
				result = stmt.executeQuery(qry);
				
				while(result.next()) {
					int id = result.getInt(1);
					String name = result.getString(2);
					int dept = result.getInt(3);
					String doj = result.getString(4);
					int salary = result.getInt(5);
					String gujaratiName = result.getString("gujaratiName");
					
					e = new EmployeeBean(id, name, dept, doj, salary, gujaratiName);
					list.add(e);
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} 
		
		
		return list;
	}
	public EmployeeBean displayOne(int eid) {
		String qry = "Select * from Employee where empId = " + eid;
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet result = null;
		
		EmployeeBean e = null;
		
		if(conn != null) {
			try {
				stmt = conn.createStatement();
				result = stmt.executeQuery(qry);
				
				result.next();
				
				int id = result.getInt(1);
				String name = result.getString(2);
				int dept = result.getInt(3);
				String doj = result.getString(4);
				int salary = result.getInt(5);
				
				e = new EmployeeBean(id, name, dept, doj, salary);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return e;
	}
}
