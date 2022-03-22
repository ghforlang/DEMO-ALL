package com.edu.nbu.cn.datatransfer.model.type;

import com.edu.nbu.cn.datatransfer.contants.TypeEnum;

/**
 * @author laoshi . hua
 * @version 1.0 2022/3/22-5:31 下午
 * @since 1.0
 */
public interface TypeWrapper<T> {

    T getType();

    TypeEnum getTypeCategory();

    String getTypeName();
}
