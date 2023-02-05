// link : https://leetcode.com/problems/longest-common-subsequence/submissions/


// RECURSION

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int ans = recursion(text1.length()-1, text2.length()-1, text1, text2);
        return ans;
    }
    
    private int recursion(int index1, int index2, String text1, String text2) {
        //base case
        
        if(index1 < 0 || index2 < 0) {
            return 0;
        }
        
        if(text1.charAt(index1) == text2.charAt(index2))
            return 1 + recursion(index1-1, index2-1, text1, text2);
        
        return 0 + Math.max(recursion(index1-1,index2,text1,text2), recursion(index1, index2-1, text1, text2));
    }
}

//MEMOIZATION

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++)
            Arrays.fill(dp[i], -1 );
        int ans = recursion(text1.length()-1, text2.length()-1, text1, text2, dp);
        return ans;
    }
    
    private int recursion(int index1, int index2, String text1, String text2, int[][] dp) {
        //base case
        
        if(index1 < 0 || index2 < 0) {
            return 0;
        }
        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        
        if(text1.charAt(index1) == text2.charAt(index2))
            return dp[index1][index2] = 1 + recursion(index1-1, index2-1, text1, text2, dp);
        
        return dp[index1][index2] = 0 + Math.max(recursion(index1-1,index2,text1,text2, dp), recursion(index1, index2-1, text1, text2, dp));
    }
}
