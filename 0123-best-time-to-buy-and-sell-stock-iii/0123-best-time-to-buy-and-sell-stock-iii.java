class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        for (int[][] array2D: dp) {
            for (int[] array1D: array2D) {
                array1D[0] = 0;
                array1D[1] = 0; 
                array1D[2] = 0; 
            }
        }
        for(int index = prices.length -1;index>=0;index--) {
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++) {
                    if(buy == 1) {
                        dp[index][buy][cap] = Math.max(-prices[index] + dp[index+1][0][cap],dp[index+1][1][cap]);
                    }
                    else {
                        dp[index][buy][cap] = Math.max(prices[index] + dp[index+1][1][cap-1], dp[index+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}