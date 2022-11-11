class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                else if(i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                
                int up = 0;
                int left = 0;
                if(i-1>=0) {
                    up = dp[i-1][j];
                }
                if(j-1>=0) {
                    left = dp[i][j-1]; 
                }
                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];
    }
}