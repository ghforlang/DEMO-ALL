package com.edu.nbu.cn.function.base;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/10-11:26 AM
 * @since 1.0
 */
public interface Response<T> {
    T getData();

    static Response defaultResponse(){
        return new Response() {
            @Override
            public Object getData() {
                return "success";
            }
        };
    }
}
