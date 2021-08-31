package com.edu.nbu.cn;

/**
 *
 * @version 1.0
 * @Date 2021/5/23 6:32 下午
 * @since 1.0
 */
public class ForTest {
    private static final int[] INT_ARR = {1,2,0,3,4};

    public static void main(String[] args) {
        int num = 20;
        Exception ex = null;
        for (int i=0;i<INT_ARR.length;i++){
            try{
                if(ex == null){
                    System.out.println(num / INT_ARR[i]);
                }
            }catch (Exception e){
                ex = e;
                System.out.println(ex.getMessage());
            }
        }
    }
}
