package com.edu.nbu.cn.ddd.demo;


import com.edu.nbu.cn.ddd.acl.*;
import com.edu.nbu.cn.ddd.common.Result;
import com.edu.nbu.cn.ddd.domain.AccountTransferService;
import com.edu.nbu.cn.ddd.domain.AccountTransferServiceImpl;
import com.edu.nbu.cn.ddd.dp.AccountNumber;
import com.edu.nbu.cn.ddd.dp.ExchangeRate;
import com.edu.nbu.cn.ddd.dp.Money;
import com.edu.nbu.cn.ddd.dp.UserId;
import com.edu.nbu.cn.ddd.entity.Account;
import com.edu.nbu.cn.ddd.entity.AuditMessage;
import com.edu.nbu.cn.ddd.repository.AccountRepository;
import com.edu.nbu.cn.ddd.repository.AccountRepositoryImpl;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

public class TransferServiceNew implements TransferService{

    // TODO spring bean注入

    private AccountTransferService accountTransferService = new AccountTransferServiceImpl();
    private AccountRepository accountRepository = new AccountRepositoryImpl();
    private ExchangeRateService exchangeRateService = new ExchangeRateServiceImpl();
    private AuditMessageProducer messageProducer = new AuditMessageProducerImpl();

    @Override
    public Result<Boolean> transfer(Long userId, String accountNumber, BigDecimal targetAmount, String currentCurrency) {
        Money targetMoney = new Money(targetAmount, Currency.getInstance(currentCurrency));

        Account fromAccount = accountRepository.find(new UserId(userId));
        Account targetAccount = accountRepository.find(new AccountNumber(accountNumber));

        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(fromAccount.getCurrency(),targetAccount.getCurrency());
        accountTransferService.transfer(fromAccount,targetAccount,targetMoney,exchangeRate);

        accountRepository.save(fromAccount);
        accountRepository.save(targetAccount);

        AuditMessage message = new AuditMessage(fromAccount,targetAccount,new UserId(userId),targetMoney,new Date());
        messageProducer.send(message);

        return Result.success();
    }
}
