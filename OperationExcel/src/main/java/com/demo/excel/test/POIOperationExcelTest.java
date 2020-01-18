package com.demo.excel.test;

import com.demo.excel.ExcelPoiReaderUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

public class POIOperationExcelTest {

    @Test
    public void readExcel() {
//        String xlsFilePath = "D:\\test\\apitest.xls";
        String xlsFilePath = "D:\\test\\apitest.xlsx";
        String[] columns = {"id","name","address"};
        List<List<Object>> excelData = ExcelPoiReaderUtils.readExcel(xlsFilePath, 0, columns);
        excelData.forEach(row -> System.out.println(row));
    }
}
