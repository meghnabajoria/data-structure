class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i], -1);
        return recursion(m-1, n-1, 0, 0, dp);
    }
    
    private int recursion(int m, int n, int row, int col, int[][] dp) {
        if(row == m && col == n) {
            return 1;
        }
        
        if(row >m || col > n) {
            return 0;
        }
        if(dp[row][col] != -1) return dp[row][col];
        int down = recursion(m,n, row+1, col,dp);
        int right = recursion(m,n,row, col+1,dp);
        return dp[row][col] = down+right;
    }
}