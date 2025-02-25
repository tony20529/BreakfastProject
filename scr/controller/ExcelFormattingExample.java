package controller;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import service.impl.CustomerServiceImpl;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;




public class ExcelFormattingExample {
	
	public static void main(String[] args) {
    	CustomerServiceImpl customerserviceimpl=new CustomerServiceImpl();

       
    	
        // 創建一個新的工作簿
        Workbook workbook = new XSSFWorkbook();

        // 創建一個工作表
        Sheet sheet = workbook.createSheet("顧客名單");

        // 創建字體樣式
        Font headerFont = workbook.createFont();
        headerFont.setFontName("宋體");
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());

        // 創建標題樣式
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);

        // 創建數據字體樣式
        Font dataFont = workbook.createFont();
        dataFont.setFontName("宋體");
        dataFont.setFontHeightInPoints((short) 12);

        // 創建數據樣式
        CellStyle dataStyle = workbook.createCellStyle();
        dataStyle.setFont(dataFont);
        dataStyle.setAlignment(HorizontalAlignment.CENTER);
        dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        dataStyle.setBorderTop(BorderStyle.THIN);
        dataStyle.setBorderBottom(BorderStyle.THIN);
        dataStyle.setBorderLeft(BorderStyle.THIN);
        dataStyle.setBorderRight(BorderStyle.THIN);

        // 創建標題
        Row headerRow = sheet.createRow(0);
        String[] headers = {"顧客編號", "顧客編號","顧客申請日期", "顧客姓名", "顧客帳號", "顧客密碼","顧客性別", "顧客年齡","顧客電話","顧客地址"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
        
        String[][] data = customerserviceimpl.AllEx();
        for (int i = 0; i < data.length; i++) {
            Row dataRow = sheet.createRow(i + 1);
            for (int j = 0; j < data[i].length; j++) {
                Cell cell = dataRow.createCell(j);
                cell.setCellValue(data[i][j]);
                cell.setCellStyle(dataStyle);
            }
        }

        // 自動調整列寬
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
            
        // 保存文件
        try (FileOutputStream fileOut = new FileOutputStream("customer.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel 文件創建並排版成功！");
        
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
	}
}