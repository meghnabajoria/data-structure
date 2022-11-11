class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[m];
        for(int i=0;i<m;i++) {
            int[] curr = new int[n];
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    curr[j] = 0;
                    continue;
                }
                else if(i == 0 && j == 0) {
                    curr[j] = 1;
                    continue;
                }
                
                int up = 0;
                int left = 0;
                if(i-1>=0) {
                    up = prev[j];
                }
                if(j-1>=0) {
                    left = curr[j-1]; 
                }
                curr[j] = up + left;
            }
            prev = curr;
        }
        return prev[n-1];
    }
}