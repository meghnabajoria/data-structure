class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++) {
            dp[0][i] = 0;
        }
        
        for(int index1 = 1;index1<=n;index1++) {
            for(int index2 = 1;index2<=m;index2++) {
                if(str1.charAt(index1 - 1) == str2.charAt(index2 - 1)) {
                    dp[index1][index2] = 1 + dp[index1-1][index2-1];
                }
                else {
                    dp[index1][index2] = 0 + Math.max(dp[index1-1][index2], dp[index1][index2-1]);
                }
            }
        }
        
        int len = dp[n][m];
        int i = n;
        int j = m;
        int index = len - 1;
        String ans = "";
        
        while(i > 0 && j > 0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                ans = ans + str1.charAt(i-1);
                index--;
                i--;
                j--;
            }
            else if(dp[i - 1][j] > dp[i][j - 1]) {
                ans = ans+ str1.charAt(i-1);
                 i--;
            }
            else {
                ans = ans+ str2.charAt(j-1);
                 j--;
            }
        }
        
        while(i>0){
            ans += str1.charAt(i-1);
            i--;
        }
        while(j>0){
            ans += str2.charAt(j-1);
            j--;
        }
        String ans2=new StringBuilder(ans).reverse().toString();
  
        return ans2;
        
    }
}