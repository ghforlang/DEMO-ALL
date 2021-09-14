package com.edu.nbu.cn.ddd.demo;


import com.edu.nbu.cn.ddd.common.Result;

import java.math.BigDecimal;

public interface TransferService {

    Result<Boolean> transfer(Long userId, String accountNumber,BigDecimal targetAmount,String currentCurrency );
}
