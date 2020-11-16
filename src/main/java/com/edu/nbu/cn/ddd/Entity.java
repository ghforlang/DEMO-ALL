package com.edu.nbu.cn.ddd;

import java.io.Serializable;

public interface Entity<T> extends Serializable {

    /**
     * 实体唯一性判断
     * @param other
     * @return
     */
    boolean sameIdentityAs(T other);
}
