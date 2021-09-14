package com.edu.nbu.cn.ddd.domain;


import com.edu.nbu.cn.ddd.dp.ExchangeRate;
import com.edu.nbu.cn.ddd.dp.Money;
import com.edu.nbu.cn.ddd.entity.Account;

public interface AccountTransferService {

    boolean transfer(Account fromAccount, Account toAccount, Money transferAmount, ExchangeRate exchangeRate);
}
