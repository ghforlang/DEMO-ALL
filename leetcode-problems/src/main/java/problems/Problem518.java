package problems;

/**
 *
 * @version 1.0
 * @Date 2021/6/10 8:32 下午
 * @since 1.0
 */
public class Problem518 {
    private static final  int[] coins = {1,2,5};
    private static final int amount = 5;

    public static void main(String[] args) {
        System.out.println("result = " + change(amount,coins));
        System.out.println("result = " + change1(amount,coins));
    }

    public static int change1(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        for(int count : dp ){
            System.out.println(count);
        }
        return dp[amount];
    }

    public static  int change(int amount, int[] coins) {
        int[] tempSolution = new int[amount +1];
        tempSolution[0] = 1;
        for(int i=0;i<coins.length;i++){
            for(int j = coins[i]; j <= amount ;j++){
                tempSolution[j] += tempSolution[j -coins[i]];
            }
        }
        for(int coin : tempSolution){
            System.out.println(coin);
        }
        return tempSolution[amount];
    }
}
