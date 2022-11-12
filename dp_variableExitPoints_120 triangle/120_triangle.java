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
