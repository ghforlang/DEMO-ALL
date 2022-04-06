package com.edu.nbu.cn.data.cleanout.utils;

/**
 * {@link IdGenerator}对象能够不断生成下一个ID。
 *
 * @author fengwk
 */
public interface IdGenerator<ID> {

    /**
     * 生成下一个id。
     * 
     * @return
     */
    ID next();

}
