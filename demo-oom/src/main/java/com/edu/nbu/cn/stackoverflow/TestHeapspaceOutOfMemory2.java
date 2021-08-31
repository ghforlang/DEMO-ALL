package com.edu.nbu.cn.stackoverflow;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TestHeapspaceOutOfMemory2 {

    static String base = "base";
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        for(int i=0;i<Integer.MAX_VALUE;i++){
            String str = base + base;
            base = str;
            strList.add(base);
        }
    }
}
