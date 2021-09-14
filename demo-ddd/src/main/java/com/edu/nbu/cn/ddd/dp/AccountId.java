package com.edu.nbu.cn.ddd.dp;



import lombok.Data;

import java.util.Objects;

@Data
public class AccountId {
    private final Long id;

    public AccountId(Long id) {
        if(Objects.isNull(id)){
            throw new RuntimeException("id can not be null");
        }
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountId accountId = (AccountId) o;
        return id.equals(accountId.id);
    }
}
