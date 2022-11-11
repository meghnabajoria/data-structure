// link : https://leetcode.com/problems/minimum-path-sum/

// RECURSION
class Solution {
    int min = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        //int[][] sum = new int[grid.length][grid[0].length];
        int max = recursion(grid, 0,0);
        return max;
    }
    
    private int recursion(int[][] grid, int row, int col) {
        if(row == grid.length - 1 && col == grid[0].length - 1) {
            return grid[grid.length-1][grid[0].length-1];
        }
        
        int down = 0;
        int right = 0;
        if(row+1<grid.length)
            down  = grid[row][col] + recursion(grid, row + 1, col);
        else
            down = Integer.MAX_VALUE;
        
        if(col + 1 < grid[0].length)
            right = grid[row][col] + recursion(grid, row, col + 1);
        else
            right = Integer.MAX_VALUE;
        
        return  Math.min(down, right);
    }
}

// MEMOIZATION

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

// TABULATION

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
                
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                
                if(i>0)
                    up = grid[i][j] + dp[i-1][j];

                
                if(j>0)
                    left = grid[i][j] + dp[i][j-1];
 
                dp[i][j] = Math.min(up,left);
            }
        } 
        return dp[n-1][m-1];
    }
}

// SPACE OPTIMIZATION

class Solution {
    int min = Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[] prev = new int[n];

       
        for(int i=0;i<n;i++) {
            int[] curr = new int[m];
            for(int j=0;j<m;j++) {
                
                if(i == 0 && j == 0) {
                    curr[j] = grid[0][0];
                    continue;
                }
                
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                
                if(i>0)
                    up = grid[i][j] + prev[j];

                if(j>0)
                    left = grid[i][j] + curr[j-1];
 
                curr[j] = Math.min(up,left);
            }
            prev = curr;
        } 
        return prev[m-1];
    }
}
