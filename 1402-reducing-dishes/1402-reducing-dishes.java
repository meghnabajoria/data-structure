class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = solveTabulation(satisfaction);
        return max;
    }
    
    private int solveTabulation(int[] satisfaction) {
        int[][] dp = new int[satisfaction.length+1][satisfaction.length+1];
        for(int i=0;i<satisfaction.length;i++)
            Arrays.fill(dp[i], 0);
        
        for(int index=satisfaction.length-1; index>=0; index--) {
            for(int time=index; time>=0; time--) {
                
                int pick = (satisfaction[index] * (time+1)) + dp[index+1][time+1];
                int notPick = dp[index+1][time];
                dp[index][time] = Math.max(pick, notPick);
                
            }
        }
        return dp[0][0];
    }
}
//MEMOIZATION
/*class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] dp = new int[satisfaction.length+1][satisfaction.length+1];
        for(int i=0;i<satisfaction.length;i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        int max = recursionMem(0, 1, satisfaction, dp);
        return max;
    }
    
    private int recursionMem(int index, int time, int[] satisfaction, int[][] dp) {
        if(index >= satisfaction.length)
            return 0;
       
        if(dp[index][time] != Integer.MIN_VALUE) {
            return dp[index][time];
        }
        
        int pick = (satisfaction[index] * time) + 
            recursionMem(index+1, time + 1, satisfaction, dp);
        
        // dont pick
        int notPick = recursionMem(index+1, time, satisfaction, dp);
        return dp[index][time] = Math.max(pick, notPick);
    }
}*/

// RECURSION
/*class Solution {
    
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        
        int max = recursion(0, 1, satisfaction);
        return max;
    }
    
    private int recursion(int index, int time, int[] satisfaction) {
        if(index >= satisfaction.length) {
            return 0;
        }
       
        int pick = (satisfaction[index] * time) + recursion(index+1, time + 1, satisfaction);
        
        // dont pick
        int notPick = recursion(index+1, time, satisfaction);
        return Math.max(pick, notPick);
    }
}*/