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