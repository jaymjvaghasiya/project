package com.royal.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.royal.bean.EmployeeBean;
import com.royal.dao.EmployeeDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class PDFGeneratorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");  // Handle UTF-8 characters
        response.setContentType("application/pdf; charset=UTF-8");

        String jasperfilePath = "F:\\project\\Project-2\\src\\main\\webapp\\WEB-INF\\reports\\employeeReport.jasper";
        String fontPath = "C:\\Windows\\Fonts\\ARIALUNI.TTF";  
        
        try {

            JasperReport jasperreport = (JasperReport) JRLoader.loadObjectFromFile(jasperfilePath);
            
         // Handle custom font (Arial Unicode MS)
            Map<String, Object> fontMap = new HashMap<String, Object>();
            fontMap.put("pdfFontName", fontPath);  // Path to the custom font file
            fontMap.put("pdfEncoding", "Identity-H");  // Proper encoding for Unicode
            fontMap.put("isPdfEmbedded", true);  // Embed the font

            
            
            EmployeeDao edao = new EmployeeDao();
            List<EmployeeBean> employeeList = edao.displayAllEmployees();
            
            JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(employeeList);

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("TABLE_DATA_SOURCE", datasource);

            parameters.putAll(fontMap);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperreport, parameters, datasource);

//          JasperExportManager.exportReportToPdfFile(jasperPrint, "F:\\project\\Project-2\\src\\main\\webapp\\WEB-INF\\generatedreport\\newdata.pdf");
            
            
            response.setHeader("Content-Disposition", "attachment; filename=EmployeeReport.pdf");

            OutputStream outputStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            outputStream.flush();
            outputStream.close();

            System.out.println("Report Generated and sent to the client successfully.");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}