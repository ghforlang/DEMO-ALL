package com.edu.nbu.cn.ddd.builder;

import com.edu.nbu.cn.ddd.dataobject.AccountDO;
import com.edu.nbu.cn.ddd.dp.AccountId;
import com.edu.nbu.cn.ddd.dp.AccountNumber;
import com.edu.nbu.cn.ddd.dp.Money;
import com.edu.nbu.cn.ddd.dp.UserId;
import com.edu.nbu.cn.ddd.entity.Account;
import lombok.experimental.UtilityClass;

import java.util.Currency;

@UtilityClass
public class AccountBuilder {

    public static Account buildAccount(AccountDO accountDO){
        Account account = new Account(new AccountId(accountDO.getId()),new AccountNumber(accountDO.getAccountNumber()),new UserId(accountDO.getUserId()),new Money(accountDO.getCurrentAmount(), Currency.getInstance("CNY")));
        return account;
    }

    public static AccountDO buildAccountDO(Account account){
        AccountDO accountDO = new AccountDO();
        accountDO.setAccountNumber(account.getAccountNumber().getNumber());
        accountDO.setCurrentAmount(account.getAvailableCount().getMoney());
        accountDO.setId(account.getAccountId().getId());
        accountDO.setName("default");
        accountDO.setUserId(account.getUserId().getUserId());
        return accountDO;
    }
}
