class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
            for(int i=0;i<word1.length();i++)
                Arrays.fill(dp[i], -1);
        int common = recursion(word1.length() - 1, word2.length() - 1, word1, word2, dp);
        //System.out.println("common : "  + common);
        return word1.length() - common + word2.length() - common;
    }
    
    private int recursion(int index1, int index2, String word1, String word2, int[][] dp) {
        // base case
        if(index1 < 0 || index2 < 0) {
            return 0;
        }
        
        if(dp[index1][index2] != -1)
            return dp[index1][index2];
        // match
        if(word1.charAt(index1) == word2.charAt(index2)) {
            return 1+ recursion(index1 - 1, index2 - 1, word1, word2, dp);
        }
        
        // not match
        return dp[index1][index2] = 0 + Math.max(recursion(index1 - 1, index2, word1, word2, dp) , recursion(index1, index2-1, word1, word2, dp));
    }
}