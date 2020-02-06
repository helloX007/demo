package com.demo.freemarker.result;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ${className} {
    <#list fields as field>
        private ${field.type} ${field.name}; // ${field.comment}
    </#list>

}