public class StockMaxProfit {
    /**
     * Design an algorithm to find the maximum profit , one transaction
      */

    public static int StockMaxProfit1(int[] stock) {
        int len = stock.length;
        int min = stock[0];
        int max = stock[0];
        int maxProfit = 0;
        for (int i = 1; i < len; i++) {
            if (stock[i] >= max) max = stock[i];
            else{
                maxProfit = Integer.max(maxProfit, max-min);
                min = stock[i];
                max = stock[i];
            }
        }
        return maxProfit;
    }

    /**
     * max two transactions
     */

    public static int StockMaxProfit2(int[] stock) {

        int len = stock.length;
        int[] benefit1 = new int[len];
        benefit1[0] = 0;

        for(int i = 1; i < len; i++)
            benefit1[i] = Math.max(stock[i]-stock[i-1], benefit1[i-1]);


        int[] benefit2 = new int[len];
        benefit2[len-1] = 0;

        for(int j = len - 2 ; j >= 0; j--)
            benefit2[j] = Math.max(benefit2[j+1], stock[j+1] - stock[j]);

        int[] benefit3 = new int[len];
        benefit3[0] = 0+benefit2[0];
        int max = benefit3[0];

        for(int i = 1; i < len; i++) {
            benefit3[i] = benefit1[i-1]+benefit2[i];
            if(benefit3[i] > max )
                max = benefit3[i];
        }
        return max;
    }


    public static int StockMaxProfit3(int[] stock) {
        int len = stock.length;
        int min = stock[0];
        int max = stock[0];
        int maxProfit = 0;
        for (int i = 1; i < len; i++) {
            if(stock[i] < max) {
                maxProfit+=max-min;
                min = stock[i];
                max=stock[i];
            }
            if(stock[i] < min) {
                min = stock[i];
                max = stock[i];
            }
            if(stock[i]> max)
                max = stock[i];
        }
        maxProfit += max - min;
        return maxProfit;
    }


    public static void main(String[] args) {
        int s[] = {3,3,0,5,0,0,3,1,4};
        int s2[] = {12,11,13,9,12,8,14,13,15};
        int p1 = StockMaxProfit2(s);
        int p2 = StockMaxProfit1(s);
        int p3 = StockMaxProfit2(s2);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }

}
