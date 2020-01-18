package com.demo.freemarker.test;

import com.demo.freemarker.FreemarkerUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerUtilsTest {

    @Test
    public void testCreateJavaFile(){
        String templateFilePath = "src/main/java/com/demo/freemarker/templates/javatemplate.ftl";
        String resultFilePath = "src/main/java/com/demo/freemarker/result/User.java";

        Map<String,Object> rootData = new HashMap<>();
        rootData.put("className","User");

        List<Map<String,String>> fields = new ArrayList<>();

        Map<String,String> field1 = new HashMap<>();
        field1.put("type","String");
        field1.put("name","userName");
        field1.put("comment","用户名");
        fields.add(field1);

        Map<String,String> field2 = new HashMap<>();
        field2.put("type","String");
        field2.put("name","address");
        field2.put("comment","地址");
        fields.add(field2);

        rootData.put("fields",fields);
        FreemarkerUtils.createJavaFile(templateFilePath,resultFilePath,rootData);
    }

}
