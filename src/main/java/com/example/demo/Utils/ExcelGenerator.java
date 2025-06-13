package com.example.demo.Utils;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.CitizenPlan;
import com.example.demo.repo.CitizenPlanRepo;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {

	public XSSFWorkbook generateExcel(List<CitizenPlan> plans) throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Plans");

        // Header row
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Status");
        headerRow.createCell(3).setCellValue("Gender");
        headerRow.createCell(4).setCellValue("PlanName");

        // Data rows
        int rowNum = 1;
        for (CitizenPlan plan : plans) {
            XSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(plan.getId());
            row.createCell(1).setCellValue(plan.getName());
            row.createCell(2).setCellValue(plan.getPlanStatus());
            row.createCell(3).setCellValue(plan.getGender());
            row.createCell(4).setCellValue(plan.getPlanName());
        }
        return workbook;
	}
}
