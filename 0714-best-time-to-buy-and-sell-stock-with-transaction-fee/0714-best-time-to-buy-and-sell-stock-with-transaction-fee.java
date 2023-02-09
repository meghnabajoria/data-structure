class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<dp.length;i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return recursion(0, 1, prices, fee, dp);
    }
    
    private int recursion(int index, int buy, int[] prices, int fee, int[][] dp) {
        if(index >= prices.length) return 0;
        
        if(dp[index][buy] != -1) return dp[index][buy];
        if(buy == 1) {
            return dp[index][buy] = Math.max(-prices[index] + recursion(index+1, 0, prices, fee, dp),
                           0 + recursion(index+1, 1, prices, fee, dp));
        }
        else {
            return dp[index][buy] = Math.max(-fee + prices[index] + recursion(index+1, 1, prices, fee, dp), recursion(index+1, 0, prices, fee, dp));
        }
    }
}