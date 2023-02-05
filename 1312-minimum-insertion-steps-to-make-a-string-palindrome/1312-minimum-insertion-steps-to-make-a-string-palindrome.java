class Solution {
    public int minInsertions(String s) {
        return s.length() - findLongestPalindromicSequence(s);
    }
    private int findLongestPalindromicSequence(String s) {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        String r = sb.toString();
        int[][] dp = new int[s.length()][r.length()];
        for(int i=0;i<s.length();i++)
            Arrays.fill(dp[i], - 1);
        return recursion(s.length() - 1, r.length() - 1, s, r, dp);
    }
    
    private int recursion(int index1, int index2, String text1, String text2, int[][] dp) {
        // base case
        if(index1 < 0 || index2 < 0)
            return 0;
        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        // match
        if(text1.charAt(index1) == text2.charAt(index2))
            return dp[index1][index2] = 1+recursion(index1-1, index2-1, text1, text2,dp);
        
        return dp[index1][index2] = 0 + Math.max(recursion(index1-1, index2, text1, text2,dp), recursion(index1, index2-1, text1, text2,dp));
    }
}