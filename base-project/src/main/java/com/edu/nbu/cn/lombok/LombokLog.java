package com.edu.nbu.cn.lombok;

import lombok.Data;
import lombok.extern.java.Log;

@Log
@Data
public class LombokLog {
    private String name;
    private Integer age;

    public static void main(String[] args) {
        LOGGER.info("this is a log test!");
    }
}
