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
