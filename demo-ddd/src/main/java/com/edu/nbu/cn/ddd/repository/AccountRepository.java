package com.edu.nbu.cn.ddd.repository;


import com.edu.nbu.cn.ddd.dp.AccountId;
import com.edu.nbu.cn.ddd.dp.AccountNumber;
import com.edu.nbu.cn.ddd.dp.UserId;
import com.edu.nbu.cn.ddd.entity.Account;

public interface AccountRepository {
    Account find(UserId userId);
    Account find(AccountId accountId);
    Account find(AccountNumber accountNumber);
    Account save (Account account);
}
