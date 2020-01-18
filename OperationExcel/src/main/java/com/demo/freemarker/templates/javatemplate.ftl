package com.demo.freemarker.result;

public class ${className} {
    <#list fields as field>
        private ${field.type} ${field.name}; // ${field.comment}
    </#list>

}