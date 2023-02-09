class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length+1][2][k+1];
        for(int[][] a2 : dp) {
            for(int[] a1: a2) {
                for(int i=0;i<=k;i++) {
                    a1[i] = -1;
                }
            }
        }
        return recursion(0, 1, k, prices, dp);
    }
    private int recursion(int index, int buy, int cap, int[] prices, int[][][] dp) {
        if(cap == 0) return 0;
        if(index >= prices.length) return 0;
        
        if(dp[index][buy][cap] != -1) return dp[index][buy][cap];
        
        if(buy == 1) {
            return dp[index][buy][cap] = Math.max(-prices[index] + recursion(index+1, 0, cap, prices, dp) ,
                           0 + recursion(index+1, 1, cap, prices, dp));
        }
        else {
            return dp[index][buy][cap] = Math.max(prices[index] + recursion(index+1, 1, cap-1, prices, dp),
                           0 + recursion(index+1, 0, cap, prices, dp));
        }
    }
}