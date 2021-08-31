package problems;

/**
 *
 * @version 1.0
 * @Date 2021/6/23 4:36 下午
 * @since 1.0
 */
public class Problem191 {

    // 二进制中1的个数
    public static void main(String[] args) {
        int num = 9999;
        System.out.println(Integer.toBinaryString(num));
    }

    public int hammingWeight(int n){
        int sum = 0;
        String nStr = Integer.toBinaryString(n);
        for(char c : nStr.toCharArray()){
            if(c == '1'){
                sum ++;
            }
        }
        return sum;
    }


    public int hammingWeight2(int n){
        int sum = 0;
        for(int i=0;i<32;i++){
            if((n & (1<<i)) != 0){
                sum ++;
            }
        }
        return sum;
    }


}
