class Solution {
    int min = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
            Arrays.fill(dp[i], -1);
        int max = recursion(grid, 0,0, dp);
        return max;
    }
    
    private int recursion(int[][] grid, int row, int col, int[][] dp) {
        if(row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[grid.length-1][grid[0].length-1];
        }
        
        int down = 0;
        int right = 0;
        
        if(dp[row][col] != -1) return dp[row][col];
        
        if(row+1<grid.length)
            down  = grid[row][col] + recursion(grid, row + 1, col, dp);
        else
            down = Integer.MAX_VALUE;
        
        if(col + 1 < grid[0].length)
            right = grid[row][col] + recursion(grid, row, col + 1, dp);
        else
            right = Integer.MAX_VALUE;
        
        return  dp[row][col] = Math.min(down, right);
    }
}