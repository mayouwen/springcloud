package com.ustb.registerservice.util;

import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * ClassName：ExcelUtil
 * Description:
 * author: mayouwen
 * date: 2020/9/1
 */
public class ExcelUtil {
    public static SXSSFWorkbook initExcel(Integer totalRowCount, Integer sheetCount, String[] titles) {
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        for (int i = 0; i< sheetCount; i++) {
            SXSSFSheet sheet = wb.createSheet("sheet" + (i + 1));
            SXSSFRow headRow = sheet.createRow(0);
            for (int j = 0; j < titles.length; j++) {
                SXSSFCell headRowCell = headRow.createCell(j);
                headRowCell.setCellValue(titles[j]);
            }
        }
        return wb;
    }
}
