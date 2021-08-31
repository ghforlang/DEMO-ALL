package com.edu.nbu.cn;

public class Test {

    //补码 -> 原码，符号位不变，其他位取反 + 1；
    public static void main(String[] args) {
        int b = 0x08;
        int b1 = 0x01;
        int b2 = 0x09;

        //与运算
        //  b   0000 1000
        //  b1  0000 0001
        //  =   0000 0000  0

        //  b   0000 1000
        //  b2  0000 1001
        //  =   0000 1000  8
        System.out.println("b & b1 = " + (b & b1));
        System.out.println("b & b2 = " + (b & b2));

        //或运算
        //  b   0000 1000
        //  b1  0000 0001
        //  =   0000 1001  9

        //  b   0000 1000
        //  b2  0000 1001
        //  =   0000 1001  9
        System.out.println("b | b1 = " + (b | b1));
        System.out.println("b | b2 = " + (b | b2));

        //按位异或，相等为0 ，不等为1
        //  b   0000 1000
        //  b1  0000 0001
        //  =   0000 1001  9

        //  b   0000 1000
        //  b2  0000 1001
        //  =   0000 0001  1
        System.out.println("b ^ b1 = " + (b ^ b1));
        System.out.println("b ^ b2 = " + (b ^ b2));

        //按位取反
        // 0000 0001 --反码--> 1111 1110(首位符号位) --表示的真值-->1000 0010(除去符号位，按位取反+1即为真值) -2
        // 0000 1001 --反码--> 1111 0110(首位符号位) --表示的真值-->1000 1010(除去符号位，按位取反+1即为真值) -10
        System.out.println("～b1 = " + (~ b1));
        System.out.println("～b2 = " + (~ b2));
    }
}
