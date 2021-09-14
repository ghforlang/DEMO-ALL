package com.edu.nbu.cn.ddd.domain;


import com.edu.nbu.cn.ddd.dp.ExchangeRate;
import com.edu.nbu.cn.ddd.dp.Money;
import com.edu.nbu.cn.ddd.entity.Account;

public class AccountTransferServiceImpl implements AccountTransferService{
    @Override
    public boolean transfer(Account fromAccount, Account toAccount, Money sourceMoney, ExchangeRate exchangeRate) {
        Money targetMoney = exchangeRate.changeTo(sourceMoney);
        fromAccount.deposit(sourceMoney);
        toAccount.withDraw(targetMoney);
        return true;
    }
}
