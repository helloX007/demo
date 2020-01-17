package com.demo.excel;

import java.util.List;

public class POIOperationExcelTest {
    public static void main(String[] args) {
//        String xlsFilePath = "D:\\test\\apitest.xls";
        String xlsFilePath = "D:\\test\\apitest.xlsx";
        String[] columns = {"id","name","address"};
        List<List<Object>> excelData = ExcelPoiReaderUtils.readExcel(xlsFilePath, columns);
        excelData.forEach(row -> System.out.println(row));
    }
}
