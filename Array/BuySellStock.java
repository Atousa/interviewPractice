public class BuySellStock {
    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int previousMin = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            maxProfit = Integer.max(prices[i]- previousMin, maxProfit);
            previousMin = Integer.min(prices[i], previousMin);
        }
        return maxProfit;

    }
}
