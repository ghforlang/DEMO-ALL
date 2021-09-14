package com.edu.nbu.cn.ddd.mock;


import java.math.BigDecimal;

public class MockThirdServiceImpl implements MockThirdService{
    @Override
    public BigDecimal getExchangeRate(int sourceValue, int targetValue) {
        return new BigDecimal(0.67);
    }
}
