package com.bankSystem.Bank.AccountSystem.Report;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Component
public class ReportConstants {
    public static final String pathToReports = "C:\\Users\\Admin\\Desktop\\roodh\\Reports";

    public String generateAReport(String jasperReportName, String fileName, JRBeanCollectionDataSource dataSource) throws Exception {
        File file = new File("C:\\Users\\Admin\\Documents\\GitHub\\SpringBootSchoolProject\\src\\main\\resources\\" + jasperReportName + ".jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "R");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);  //fillReport combine it all
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\" + fileName + ".pdf");
        return "Report generated : " + pathToReports + "\\" + fileName + ".pdf";
    }
}
