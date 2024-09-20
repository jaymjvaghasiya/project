package com.royal.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.royal.bean.DataBean;
import com.royal.dao.DataDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * Servlet implementation class GetDataServlet
 */
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetDataServlet() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataDao data = new DataDao();
		ArrayList<DataBean> l = data.displayAllData();
		
		for(int i = 0; i < l.size(); i++) {
			DataBean db = l.get(i);
			System.out.println(db.getFirst_name());
		}
		
		String jasperfilePath = "F:\\project\\precticeProject\\src\\main\\webapp\\WEB-INF\\report\\namereport.jasper";
		try {
			
			JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(jasperfilePath);
			Map<String, Object> parameter = new HashMap<String, Object>();
			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(l);
			parameter.put("TABLE_DATA_SOURCE", datasource);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, datasource);

//			JasperExportManager.exportReportToPdfFile(jasperPrint, "F:\\project\\precticeProject\\src\\main\\webapp\\WEB-INF\\report\\newdata.pdf");

			response.setHeader("Content-Disposition", "attachment; filename=EmployeeReport.pdf");

            OutputStream outputStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            outputStream.flush();
            outputStream.close();

            System.out.println("Report Generated and sent to the client successfully.");
			
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
