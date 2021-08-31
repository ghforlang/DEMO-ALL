package problems;

/**
 *
 * @version 1.0
 * @Date 2021/6/11 2:46 下午
 * @since 1.0
 */
public class Problem279 {

    private static int arr[] = new int[10];
    static{
        for(int i = 0;i<10; i++){
            arr[i] = (i+1) * (i+1);
        }
    }

    // wrong answer
    public static int numSquares(int n) {
        int num = 0;
        if(n <= 0){
            return num;
        }

        for(int i =arr.length-1 ; i >= 0 ; i--){
            if(n >= arr[i]){
                if(n % arr[i] == 0 && arr[i] > 1){
                    num += (n /arr[i]);
                }else{
                    continue;
                }
            }
        }
        for(int i = arr.length -1 ; i >= 0 ; i--){
            if(n == arr[i]){
                num ++;
                return num;
            }else if(n < arr[i]){
                continue;
            }else{
                num += (n / arr[i]);
                n %= arr[i];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(19));
    }
}
