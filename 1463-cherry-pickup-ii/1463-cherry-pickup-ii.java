class Solution {
    public int cherryPickup(int[][] grid) {
        int cols = grid[0].length;
        int rows = grid.length;
        int dp[][][] = new int[rows][cols][cols];
        for(int row1[][]:dp) {
            for(int row2[]:row1) {
                Arrays.fill(row2, -1);
            }
        }
        return recursion(0, 0, cols-1, grid, dp);
    }
    
    private int recursion(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        // base case 1
        if(j1 >= grid[0].length || j2 >= grid[0].length || j1 < 0 || j2 < 0) {
            return (int)-1e8;
        }
        
        // base case 2
        if(i == grid.length - 1) {
            if(j1 == j2) {
                return grid[i][j1];
            }
            else
                return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        // traverse all the paths
        int maximum = (int)(-1e8);
        for(int d1=-1;d1<2;d1++) {
            for(int d2=-1;d2<2;d2++) {
                int value = 0;
                if( j1 == j2) {
                    value = grid[i][j1];
                }
                else {
                    value = grid[i][j1] + grid[i][j2];
                }
                value = value + recursion(i+1, j1+d1, j2+d2, grid, dp);
                maximum = Math.max(maximum, value);
            }
        }
        return dp[i][j1][j2] = maximum;
    }
}