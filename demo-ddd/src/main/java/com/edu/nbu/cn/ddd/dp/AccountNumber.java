package com.edu.nbu.cn.ddd.dp;


import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class AccountNumber {
    private final String number;

    public AccountNumber(String number) {
        if(StringUtils.isBlank(number)){
            throw new RuntimeException("accountNumber cannot be null!");
        }
        this.number = number;
    }
}
