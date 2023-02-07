class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i], -1);
        return recursion(0,1,prices, dp);
    }
    
    private int recursion(int index, int buy, int[] prices,int[][] dp) {
        if(index >= prices.length) {
            return 0;
        }
        
        if(dp[index][buy] != -1) return dp[index][buy];
        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[index] + recursion(index+1, 0, prices, dp) , 0 + recursion(index+1,1, prices, dp));
        }
        else {
            profit = Math.max(prices[index] + recursion(index+1,1, prices, dp), 0 + recursion(index+1,0, prices, dp));
        }
        return dp[index][buy] = profit;
    }
}