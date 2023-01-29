package com.example.jpacrud.config;


import com.example.jpacrud.model.SabablarPlan;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class TsPlanExcelExporter {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {
            "Ts ID",
            "uchastka",
            "nachalnik",
            "master",
            "brigadir",
            "smena",
            "toxtalish sababi",
            "toxtalish nuqtasi",
            "toxtalish sanasi",
            "start time",
            "finish time",
            "toxtalish vaqti"
    };
    static String SHEET = "Toxtalish_sabablari";

    public static ByteArrayInputStream tutorialsToExcel(List<SabablarPlan> tutorials) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (SabablarPlan tutorial : tutorials) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(tutorial.getId());
                row.createCell(1).setCellValue(tutorial.getUchastka());
                row.createCell(2).setCellValue(tutorial.getNachalnik());
                row.createCell(3).setCellValue(tutorial.getMaster());
                row.createCell(4).setCellValue(tutorial.getBrigadir());
                row.createCell(5).setCellValue(tutorial.getSmena());
                row.createCell(6).setCellValue(tutorial.getToxtalishsababi());
                row.createCell(7).setCellValue(tutorial.getToxtalishnuktasi());
                row.createCell(8).setCellValue(tutorial.getToxtalishdate().toString());
                row.createCell(9).setCellValue(tutorial.getStarttime());
                row.createCell(10).setCellValue(tutorial.getFinishtime());
                row.createCell(11).setCellValue(tutorial.getToxtaganvaqt());

            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

}
