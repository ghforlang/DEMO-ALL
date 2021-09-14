package com.edu.nbu.cn.ddd.acl;


import com.edu.nbu.cn.ddd.dp.ExchangeRate;

import java.util.Currency;

public interface ExchangeRateService {
    ExchangeRate getExchangeRate(Currency source,Currency target);
}
