public class MaxProfit {

    //we have one machine that can product two product (A,B) per day. change machine from A to B or opposite
    // takes a day without production , given the profit information , what would be the maximum possible profit.

    public static int maxProfit(int[][] forecast) {

        int r = forecast.length;
        int c = forecast[0].length;

        int[][] dp = new int[r][c];

        dp[0][0] = forecast[0][0];
        dp[1][0] = forecast[1][0];
        dp[0][1] = forecast[0][0] + forecast[0][1];
        dp[1][1] = forecast[1][0] + forecast[1][1];

        for (int i = 2; i < c; i++) {
            for (int j = 0; j < r; j++) { // two product
                dp[j][i] = Math.max(dp[j][i - 1], dp[j == 0 ? 1 : 0][i - 2]) + forecast[j][i];
            }
        }
        int max = Math.max(dp[0][c-1], dp[1][c-1]);
        return  max;
    }

    public static int maxProfit2(int[][] forecast) {

        int products = forecast.length;
        int days = forecast[0].length;

        int A = 0;
        int B = 1;


        int[][] dp = new int[2][days];

        for(int day = 0; day< days; day++) {

            dp[A][day] = Math.max(day >=1 ? dp[A][day-1] : 0 , day>= 2 ? dp[B][day-2] : 0) +
                    forecast[A][day];

            dp[B][day] = Math.max(day >=1 ? dp[B][day-1] : 0 , day>= 2 ? dp[A][day-2] : 0) +
                    forecast[B][day];
        }
        int max = Math.max(dp[A][days-1], dp[B][days-1]);
        return  max;

    }



    public static void main(String[] args) {
        int[][] forecast = {{4, 2, 1, 7}, {1, 2, 5, 4}};
        System.out.println(maxProfit(forecast));
    }
}
