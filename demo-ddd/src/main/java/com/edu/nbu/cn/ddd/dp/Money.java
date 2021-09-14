package com.edu.nbu.cn.ddd.dp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
@AllArgsConstructor
public class Money {
    private final BigDecimal money;
    private final Currency currency;

    public void add(BigDecimal money){
        this.money.add(money);
    }
}
