package com.edu.nbu.cn.ddd.dp;


import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;

@AllArgsConstructor
public class ExchangeRate {
    private final BigDecimal rate;
    private final Currency from;
    private final Currency to;

    public Money changeTo(Money  from){
        BigDecimal targetMoney = from.getMoney().multiply(rate);
        return new Money(targetMoney,to);
    }
}
