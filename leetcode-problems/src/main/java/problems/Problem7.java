package problems;

/**
 *
 * @version 1.0
 * @Date 2021/6/30 10:32 上午
 * @since 1.0
 */
public class Problem7 {
    private static final int[] intArr = {1234,2345,-123,0,-12345,-2147483648,2147483647};
    private static final int[] intArr2 = {2147483647,-2147483648};
    public static void main(String[] args) {
        for(int i=0;i< intArr.length ;i ++){
            System.out.println(intArr[i] + " : " + reverse(intArr[i]));
        }
    }

    private static int reverse(int x) {
        if(x == 0){
            return x;
        }

        int flag = 0;
        String valueStr = String.valueOf(x);
        if(valueStr.startsWith("-")){ flag = 1;
           valueStr = valueStr.substring(1);
        }

        long result = 0;
        StringBuilder sb = new StringBuilder();
        for(int i= valueStr.length()-1;i>=0 ;i--){
            sb.append(valueStr.charAt(i));
        }
        result = flag == 1 ? Long.valueOf("-" + sb.toString()) : Long.valueOf(sb.toString());
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }
}
