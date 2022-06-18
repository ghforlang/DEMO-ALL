package com.edu.nbu.cn.spring.bean;

/**
 * @author laoshi . hua
 * @version 1.0 2022/6/18-11:40 AM
 * @since 1.0
 */
public class Result {
    private String message;

    public Result(String message) {
        this.message = message;
    }

    public static Result successResult(String identifier){
        return new Result(identifier + " success!");
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                '}';
    }
}
