package com.edu.nbu.cn.ddd.entity;



import com.edu.nbu.cn.ddd.dp.AccountId;
import com.edu.nbu.cn.ddd.dp.AccountNumber;
import com.edu.nbu.cn.ddd.dp.Money;
import com.edu.nbu.cn.ddd.dp.UserId;
import lombok.Value;

import java.util.Currency;

@Value
public class Account {
    private AccountId accountId;
    private AccountNumber accountNumber;
    private UserId userId;
    private Money availableCount;

    public Currency getCurrency(){
        return this.availableCount.getCurrency();
    }

    public boolean withDraw(Money money){
        if(this.getCurrency().equals(money.getCurrency())){
            throw new RuntimeException("invalid currency!");
        }
        this.availableCount.add(money.getMoney());
        return true;
    }

    public boolean deposit(Money money){
        if(availableCount.getMoney().compareTo(money.getMoney()) < 0){
            throw new RuntimeException("unavailable money count!");
        }
        // 如果有限额，可以新增限额逻辑；
        availableCount.getMoney().subtract(money.getMoney());
        return true;
    }
}
