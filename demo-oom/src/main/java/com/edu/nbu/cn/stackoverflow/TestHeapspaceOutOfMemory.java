package com.edu.nbu.cn.stackoverflow;

import java.util.ArrayList;
import java.util.List;

public class TestHeapspaceOutOfMemory {

    public static void main(String[] args) {
        List<byte[]> byteLists = new ArrayList<>();
        int i = 0;
        boolean flag = true;
        while(flag){
            try{
                i ++;
                byteLists.add(new byte[1024 * 1024]);
            }catch (Throwable e){
                e.printStackTrace();
                flag = false;
                System.out.println("count = " + i);
            }
        }
    }
}
