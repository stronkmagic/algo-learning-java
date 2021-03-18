package leetcode;

public class BestTimeToBuyAndSellStockWithFee {
    public static void main(String[] args) {
        int[] pricesTest = {2,2,1,1,5,5,3,1,5,4};
        int[] pricesTest2 = {1,3,7,5,10,3};
        BestTimeToBuyAndSellStockWithFee solution = new BestTimeToBuyAndSellStockWithFee();
        solution.maxProfitFromSolutions(pricesTest, 2);
        solution.maxProfit(pricesTest2, 3);
    }

    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];

        int currentMin = Integer.MAX_VALUE;
        int currentMax = prices[0];
        int prevIdxSell = 0;
        dp[prevIdxSell] = 0;
        for (int i = 1; i < prices.length; i++) {
            //search new buy point
            if (currentMax - prices[i] - fee > 0) {
                currentMin = prices[i];
                currentMax = prices[i];
                prevIdxSell = i - 1;
                dp[i] = dp[i-1];
                continue;
            }
            if (currentMax < prices[i]) {
                currentMax = prices[i];
            }

            if (currentMin > prices[i - 1]) {
                currentMin = prices[i - 1];
            }

            int profit = currentMax - currentMin - fee;
            dp[i] = Math.max(dp[i - 1], profit + dp[prevIdxSell]);

        }

        return dp[prices.length-1];
    }

    public int maxProfitFromSolutions(int[] prices, int fee) {
        int profit = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, hold + prices[i] - fee);
            hold = Math.max(hold, profit - prices[i]);
        }
        return profit;
    }
}