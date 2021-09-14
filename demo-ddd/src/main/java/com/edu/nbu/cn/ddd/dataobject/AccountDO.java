package com.edu.nbu.cn.ddd.dataobject;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDO {
    private Long id;
    private String accountNumber;
    private String name;
    private BigDecimal currentAmount;
    private Long userId;
}
