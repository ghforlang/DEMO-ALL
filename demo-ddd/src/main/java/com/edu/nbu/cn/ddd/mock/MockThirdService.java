package com.edu.nbu.cn.ddd.mock;



import java.math.BigDecimal;

public interface MockThirdService {

   BigDecimal getExchangeRate(int sourceValue,int targetValue);
}
