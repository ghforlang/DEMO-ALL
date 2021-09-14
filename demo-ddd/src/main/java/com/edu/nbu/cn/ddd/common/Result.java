package com.edu.nbu.cn.ddd.common;


public class Result<T> {
    private T value;
    private boolean success = false;

    public Result(boolean success) {
        this.success = success;
    }

    public T getValue() {
        return value;
    }

    public void set(T t){
        this.value = t;
    }



    public static Result success(){
        return new Result(true);
    }
}
