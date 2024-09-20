package com.royal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.royal.bean.DataBean;
import com.royal.util.DBConnection;

public class DataDao {
	
	public ArrayList<DataBean> displayAllData() {
		String qry = "Select * from firstnames";
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet result = null;
		
		ArrayList<DataBean> list = new ArrayList<DataBean>();
		
		DataBean e = null;
		
		if(conn != null) {
			try {
				stmt = conn.createStatement();
				result = stmt.executeQuery(qry);
				
				while(result.next()) {
					String nm = result.getString(1);
					
					e = new DataBean(nm);
					list.add(e);
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} 
		
		
		return list;
	}
}