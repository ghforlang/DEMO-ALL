package com.edu.nbu.cn.ddd.repository;


import com.edu.nbu.cn.ddd.builder.AccountBuilder;
import com.edu.nbu.cn.ddd.dao.CommonDAO;
import com.edu.nbu.cn.ddd.dataobject.AccountDO;
import com.edu.nbu.cn.ddd.dp.AccountId;
import com.edu.nbu.cn.ddd.dp.AccountNumber;
import com.edu.nbu.cn.ddd.dp.UserId;
import com.edu.nbu.cn.ddd.entity.Account;

public class AccountRepositoryImpl implements AccountRepository{

    //TODO 这里应该用bean注入
    private CommonDAO commonDAO = new CommonDAO();

    @Override
    public Account find(UserId userId) {
        AccountDO accountDO = commonDAO.findByUserId(userId.getUserId());
        return AccountBuilder.buildAccount(accountDO);
    }

    @Override
    public Account find(AccountId accountId) {
        AccountDO accountDO = commonDAO.findByAccountId(accountId.getId());
        return AccountBuilder.buildAccount(accountDO);
    }

    @Override
    public Account find(AccountNumber accountNumber) {
        AccountDO accountDO = commonDAO.findByAccountNumber(accountNumber.getNumber());
        return AccountBuilder.buildAccount(accountDO);
    }

    @Override
    public Account save(Account account) {
        AccountDO accountDO = AccountBuilder.buildAccountDO(account);
        commonDAO.save(accountDO);
        return AccountBuilder.buildAccount(accountDO);
    }
}
