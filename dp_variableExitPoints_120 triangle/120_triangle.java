//link : https://leetcode.com/problems/triangle/
// QUESTION FOR VARIABLE EXIT POINTS 

// RECURSION




// MEMOIZATION

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp;
        int n = triangle.size();
	    dp = new Integer[n][n];
        int min = recursion(triangle, 0, 0,dp);
        return min;
    }
    
    private int recursion(List<List<Integer>> triangle, int row, int col, Integer[][] dp) {
        if(row == triangle.size() - 1)
            return triangle.get(row).get(col);
        
        int first = triangle.get(row).get(col);
        int second = triangle.get(row).get(col);
        
        if(dp[row][col] != null) return dp[row][col];
        if(row + 1 < triangle.size())
            first = triangle.get(row).get(col) + recursion(triangle, row + 1,col, dp);
            
        if(row + 1 < triangle.size() && col + 1 < triangle.get(triangle.size()-1).size())
            second = triangle.get(row).get(col) + recursion(triangle, row + 1, col + 1, dp);
        
        return dp[row][col] = Math.min(first, second);
    }
}

// TABULATION
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp;
	    dp = new Integer[n][n];
        for(int j=0;j<n;j++) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        
        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
            
                int down = triangle.get(i).get(j)+dp[i+1][j]; 
                int diagonal = triangle.get(i).get(j)+dp[i+1][j+1];
            
                dp[i][j] = Math.min(down, diagonal);
            }
        }
        return dp[0][0];
    }
}
