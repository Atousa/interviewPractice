import java.util.Arrays;

public class CoinChange {
//    You are given an integer array coins representing coins of
//    different denominations and an integer amount representing a total amount of money.
//
//    Return the fewest number of coins that you need to make up that amount.
//    If that amount of money cannot be made up by any combination of the coins, return -1.

    public static int coinChange(int[] coins, int amount) {

        if(amount <=0 ) return 0;

        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;


        for(int i = 1; i <= amount;i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j < coins.length; j++)
                min = Math.min( i >= coins[j] ? dp[i-coins[j]] : Integer.MAX_VALUE ,min);
            if(min != Integer.MAX_VALUE)
                dp[i] = min+1;
        }

        return (dp[amount]== Integer.MAX_VALUE ? -1 : dp[amount]);
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        int total = 3;
        int b = coinChange(coins,total);
        System.out.println(b);
    }
}
