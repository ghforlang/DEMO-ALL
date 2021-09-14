package com.edu.nbu.cn.ddd.acl;


import com.edu.nbu.cn.ddd.dp.ExchangeRate;
import com.edu.nbu.cn.ddd.mock.MockThirdService;
import com.edu.nbu.cn.ddd.mock.MockThirdServiceImpl;

import java.math.BigDecimal;
import java.util.Currency;

public class ExchangeRateServiceImpl implements ExchangeRateService{

    //TODO 依赖spring注入
    private MockThirdService mockThirdService = new MockThirdServiceImpl();

    @Override
    public ExchangeRate getExchangeRate(Currency source, Currency target) {
        if(source.equals(target)){
            return new ExchangeRate(BigDecimal.ONE,source,target);
        }
        BigDecimal exchangeRate = mockThirdService.getExchangeRate(source.getNumericCode(),target.getNumericCode());
        return new ExchangeRate(exchangeRate,source,target);
    }
}
