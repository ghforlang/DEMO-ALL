package com.edu.nbu.cn.ddd.dp;


import lombok.Data;

import java.util.Objects;

@Data
public class UserId {
    private final Long userId;

    public UserId(Long userId) {
        if(Objects.isNull(userId)){
            throw new RuntimeException("userId cannot be null!");
        }
        this.userId = userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId1 = (UserId) o;
        return Objects.equals(userId, userId1.userId);
    }

}
