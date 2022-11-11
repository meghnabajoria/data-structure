class Solution {
    int min = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dp = new int[n][m];
        // for(int i=0;i<grid.length;i++)
        //     Arrays.fill(dp[i], -1);
       
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                //int[] curr = new int[m];
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                    continue;
                }
                
                int up = 0;
                int left =0;
                
                if(i>0)
                    up = grid[i][j] + dp[i-1][j];
                else
                    up = Integer.MAX_VALUE;
                
                if(j>0)
                    left = grid[i][j] + dp[i][j-1];
                else
                    left = Integer.MAX_VALUE;
                dp[i][j] = Math.min(up,left);
            }
        } 
        return dp[n-1][m-1];
    }
}