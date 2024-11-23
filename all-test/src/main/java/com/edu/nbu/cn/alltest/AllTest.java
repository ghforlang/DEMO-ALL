package com.edu.nbu.cn.alltest;


import com.google.common.hash.Funnel;
import com.google.common.hash.Hashing;

public class AllTest {


    public static void main(String[] args) {
        // 计算bit数组长度
        int bitSize = optimalNumOfBits(1000000, 0.01);
        // 计算hash方法执行次数
        int numHashFunctions = optimalNumOfHashFunctions(1000000, bitSize);
        Funnel<String> funnel = new Funnel<String>() {
            @Override
            public void funnel(String from, com.google.common.hash.PrimitiveSink into) {
                into.putUnencodedChars(from);
            }
        };

        int[] offset = murmurHashOffset("099090",numHashFunctions,funnel,bitSize);
        for (int i=0;i<offset.length;i++){
            System.out.println(i);
        }

//        System.out.println("bitSize=" + bitSize + "，numHashFunctions=" + numHashFunctions);
    }


    private static int[] murmurHashOffset(String value,int numHashFunctions,Funnel<String> funnel,int bitSize) {
        int[] offset = new int[numHashFunctions];

        long hash64 = Hashing.murmur3_128().hashObject(value, funnel).asLong();
        int hash1 = (int) hash64;
        int hash2 = (int) (hash64 >>> 32);
        for (int i = 1; i <= numHashFunctions; i++) {
            int nextHash = hash1 + i * hash2;
            if (nextHash < 0) {
                nextHash = ~nextHash;
            }
            offset[i - 1] = nextHash % bitSize;
        }

        return offset;
    }

    /**
     * 计算bit数组长度
     */
    private static int optimalNumOfBits(long n, double p) {
        if (p == 0) {
            // 设定最小期望长度
            p = Double.MIN_VALUE;
        }
        int sizeOfBitArray = (int) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
        return sizeOfBitArray;
    }

    /**
     * 计算hash方法执行次数
     */
    private static int optimalNumOfHashFunctions(long n, long m) {
        int countOfHash = Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
        return countOfHash;
    }
}
