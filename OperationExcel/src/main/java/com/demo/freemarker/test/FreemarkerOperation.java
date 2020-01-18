package com.demo.freemarker.test;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerOperation {

    private static final String TEMPLATE_PATH="src/main/java/com/demo/freemarker/templates";
    private static final String RESULT_PATH="src/main/java/com/demo/freemarker/result";

    public static void main(String[] args) {
        /**
         * 创建Java文件的工具方法已经整理到FreemarkerUtils中，此处是原始演示代码
         */
        // 1、创建freemarker配置实例
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        Writer out = null;
        try {
            // 2、获取模板路径
            cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            /**
             * 在freemarker中的空值的处理，默认情况以${xxx}的方式取值会报错，我们一般都采用${xxx?if_exists} 的方式去处理,
             * 由于不想再模板中这样写，所以这里设置cfg的ClassicCompatible为true,以此解决空值的问题
             */
            cfg.setClassicCompatible(true);
            // 3、创建数据模型
            Map<String,Object> root = new HashMap<>();
            root.put("className","User");

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

            root.put("fields",fields);

            // 4、加载模板文件
            Template template = cfg.getTemplate("javatemplate.ftl");
            // 5、生成结果文件
            File resultFile = new File(RESULT_PATH+File.separator+"User.java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFile)));
            // 6、输出文件
            template.process(root,out);
            System.out.println("模板生成成功。");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (out !=null){
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                out = null;
            }
        }
    }
}
