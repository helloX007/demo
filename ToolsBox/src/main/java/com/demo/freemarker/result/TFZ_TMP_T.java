package com.demo.freemarker.result;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class TFZ_TMP_T {
        private String PtnTag; // 分区标志
        private String TrxSer; // 交易流水
        private String StsCod; // 状态代码
        private String DeaDat; // 成交日期
        private String RtnBch; // 成交批号
        private String TaaTaa; // 报文TA代码
        private String TaaSaa; // 报文SA代码
        private String TaaMsg; // 报文业务代码
        private BigDecimal CtlAmt; // 控制金额

}