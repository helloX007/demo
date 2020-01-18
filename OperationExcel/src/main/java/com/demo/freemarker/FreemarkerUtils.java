package com.demo.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Freemarker生成文件工具
 */
public class FreemarkerUtils {

    /**
     * 创建Java类文件
     * @param templateFilePath Java模板文件路径 绝对路径或class路径   src/main/java/com/demo/freemarker/templates/javatemplate.ftl
     * @param resultFilePath  生成结果文件的绝对路径   src/main/java/com/demo/freemarker/result/User.java
     * @param rootData  模板使用的数据，树形结构
     */
    public static void createJavaFile(String templateFilePath,String resultFilePath,Map<String,Object> rootData) {
        // 创建freemarker配置实例
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        Writer out = null;
        String templateDir = templateFilePath.substring(0,templateFilePath.lastIndexOf("/"));
        String templateFileName = templateFilePath.substring(templateFilePath.lastIndexOf("/")+1);

        try {
            // 获取模板所在目录路径
            cfg.setDirectoryForTemplateLoading(new File(templateDir));
            /**
             * 在freemarker中的空值的处理，默认情况以${xxx}的方式取值会报错，我们一般都采用${xxx?if_exists} 的方式去处理,
             * 由于不想再模板中这样写，所以这里设置cfg的ClassicCompatible为true,以此解决空值的问题
             */
            cfg.setClassicCompatible(true);

            // 加载模板文件
            Template template = cfg.getTemplate(templateFileName);
            // 生成结果文件
            File resultFile = new File(resultFilePath);
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resultFile)));
            // 输出文件
            template.process(rootData,out);
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
