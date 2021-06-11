import java.util.Arrays;

public class AmericanSoccer {

    public static int americanSoccer(int finalScore, int[] scores) {
        //validate input
        if (finalScore < 0) return -1;
        //reserve dp space
        int[] dp = new int[finalScore + 1]; //could be less we come back to it  int[6] msx of possible scores
        Arrays.fill(dp,0);
        //base case
        dp[0] = 1;
        //recursive formula
        for (int i = 1; i <= finalScore; i++) {
            for (int j = 0; j < scores.length; j++) {
                if (i >= scores[j]) {
                    dp[i] += dp[i - scores[j]];
                    //dp[i%6] += dp[(i - scores[j])%6];
                    //dp[i]+= (i >= scores[j] ? dp[i-scores[j]] : 0);
                }
            }
        }
        return dp[finalScore];
        //return dp[finalScore%6];
    }

    public static void main(String[] args) {
        int[] a= new int[]{2,3,6};
        int b  = americanSoccer(6, a);
        System.out.println(b);
    }
}


