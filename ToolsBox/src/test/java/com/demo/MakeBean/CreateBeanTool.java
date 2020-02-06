package com.demo.MakeBean;

import com.demo.excel.ExcelPoiReaderUtils;
import com.demo.freemarker.FreemarkerUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析excel文件 创建对应表的 bean 实体类
 */
public class CreateBeanTool {

    private static final String excelFileDir = "src/test/java/com/demo/MakeBean/";
    private static final String ftlFileDir = "src/main/java/com/demo/freemarker/templates/";
    private static final String resultDir = "src/main/java/com/demo/freemarker/result/";

    @Test
    public void test(){
        System.out.println("qwe".substring(1));
    }

    @Test
    public void createBean(){

        String[] headNames = {"分组名称","字段名称","字段描述","数据字典","字段类型","字段长度","小数位数","取值类型","根参数码","备注说明"};
        List<List<Object>> fieldlist = ExcelPoiReaderUtils.readExcel(excelFileDir+"TFZ_TMP_T.xlsx", 1, headNames);
        fieldlist.forEach(list -> System.out.println(list));

        List<Map<String,String>> fieldInfoList = new ArrayList();
        fieldlist.forEach(field -> {
            String fieldName = (String) field.get(1);
            String[] strings = fieldName.split("_");
            fieldName = strings[1].substring(0,1)+strings[1].substring(1).toLowerCase() + strings[2].substring(0,1)+strings[2].substring(1).toLowerCase();

            String fieldComment = (String) field.get(2);
            String fieldType = (String) field.get(4);
            switch (fieldType){
                case "CHAR" : fieldType = "String";
                    break;
                case "DECIMAL" : fieldType = "BigDecimal";
                    break;
                case "INT" : fieldType = "int";
                    break;
                default:
                    System.out.println("暂不支持此类型："+fieldType);
                    break;
            }
            Map<String,String> fieldInfo = new HashMap<>();
            fieldInfo.put("type",fieldType);
            fieldInfo.put("name",fieldName);
            fieldInfo.put("comment",fieldComment);
            fieldInfoList.add(fieldInfo);
        });

        Map<String,Object> rootData = new HashMap<>();
        rootData.put("className","TFZ_TMP_T");
        rootData.put("fields",fieldInfoList);

        FreemarkerUtils.createJavaFile(ftlFileDir+"javatemplate.ftl",resultDir+"TFZ_TMP_T.java",rootData);

    }
}
