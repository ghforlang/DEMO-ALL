package com.edu.nbu.cn.ddd.dao;


import com.edu.nbu.cn.ddd.dataobject.AccountDO;

public class CommonDAO {

    public AccountDO findByAccountId(Long accountId){
        return null;
    }

    public AccountDO findByUserId(Long userId){
        return null;
    }

    public AccountDO findByAccountNumber(String accountNo){
        return null;
    }

    public boolean save(AccountDO accountDO){
        if(accountDO.getId() != null){
            // return doUpdate();
        }
        // return doSave();
        return false;
    }
}
