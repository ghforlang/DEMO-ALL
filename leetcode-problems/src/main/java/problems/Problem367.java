package problems;

/**
 *
 * @version 1.0
 * @Date 2021/6/30 9:44 上午
 * @since 1.0
 */
public class Problem367 {
    private static final int[] intArr = {808201};
    public static void main(String[] args) {
        for (int i = 0;i<intArr.length ; i++){
            System.out.println(intArr[i] + " : " + isPerfectSquare1(intArr[i]));
        }
    }

    private static boolean isPerfectSquare1(int num){
        if(num < 2){
            return true;
        }

        long x = num /2;
        while(x * x > num){
            x = (x + num/x)/2;
        }
        return (x*x == num);
    }

    private static boolean isPerfectSquare(int num){
        if(num < 2){
            return true;
        }

        // 防止溢出，这里用long
        long left = 0,right = num/2;
        while(left <= right){
            long x = (left + right) /2;
            if(x * x == num){
                return true;
            }else if (x * x > num){
                right = x - 1;
            }else{
                left = x + 1;
            }
        }
        return false;
    }

}
