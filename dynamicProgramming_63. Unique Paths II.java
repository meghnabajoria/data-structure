//https://leetcode.com/problems/unique-paths-ii/

// RECURSION

class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int paths = recursion(grid, 0,0);
        return paths;
    }
    
    private int recursion(int[][] grid, int row, int col) {
        if(grid[row][col] == 1) {
            return 0;
        }
        if(row == grid.length - 1 && col == grid[0].length - 1) {
            return 1;
        }
        
        int down = 0;
        if(row + 1 < grid.length) 
            down = recursion(grid, row + 1, col);
        int right = 0;
        if(col +1 < grid[0].length) 
            right = recursion(grid, row, col + 1);
        return down+right;
    }
}

// MEMOIZATION

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

// TABULATION
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
