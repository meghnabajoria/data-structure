class Solution {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        if(grid[0].length == 1)
            return new int[] {-1};

        for(int i=0;i<grid[0].length;i++) {
            dfs(0, i,res, i, grid);
        }
        return res;
    }
    
    private void dfs(int row, int col, int[] res, int initialCol, int[][] grid) {
        // base condition 
        if(row >= grid.length || col >= grid[0].length) {
            res[initialCol] = col;
            return;
        }
        
        if(grid[row][col] == 1 && col+1 < grid[0].length && grid[row][col+1] == 1) {
            dfs(row+1,col+1,res,initialCol, grid);
        }
        
       else if(grid[row][col] == -1 && col-1>=0 && grid[row][col-1] == -1) {
            dfs(row+1,col-1, res,initialCol, grid);
        }
        else if(grid[row][col] == 1 && col+1>=grid[0].length) {
            res[initialCol] = -1;
            return;
        }
        else  {
            res[initialCol] = -1;
            return;
        }
    }
}