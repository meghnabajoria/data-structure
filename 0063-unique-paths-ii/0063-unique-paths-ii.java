class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
            Arrays.fill(dp[i],-1);
        int paths = recursion(grid, 0,0,dp);
        return paths;
    }
    
    private int recursion(int[][] grid, int row, int col, int[][] dp) {
        if(grid[row][col] == 1) {
            return 0;
        }
        if(row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }
        
        int down = 0;
        int right = 0;
        
        if(dp[row][col] != -1) return dp[row][col];
        if(row + 1 < grid.length) 
            down = recursion(grid, row + 1, col,dp);
        
        if(col +1 < grid[0].length) 
            right = recursion(grid, row, col + 1,dp);
        return dp[row][col] = down+right;
    }
}