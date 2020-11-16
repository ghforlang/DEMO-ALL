package com.edu.nbu.cn.ddd;

import java.io.Serializable;

public interface Value<T> extends Serializable {

    /**
     * 值对象相等判定逻辑
     * @param other
     * @return
     */
    boolean sameValueAs(T other);
}
