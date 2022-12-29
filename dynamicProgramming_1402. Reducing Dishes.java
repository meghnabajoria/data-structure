// https://leetcode.com/problems/reducing-dishes/

//RECURSION
class Solution {
    
    public static int max = Integer.MIN_VALUE;
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
}

//MEMOIZATION

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] dp = new int[satisfaction.length+1][satisfaction.length+1];
        for(int i=0;i<satisfaction.length;i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        int max = recursion(0, 1, satisfaction, dp);
        return max;
    }
    
    private int recursion(int index, int time, int[] satisfaction, int[][] dp) {
        if(index >= satisfaction.length)
            return 0;
       
        if(dp[index][time] != Integer.MIN_VALUE) {
            return dp[index][time];
        }
        
        int pick = (satisfaction[index] * time) + 
            recursion(index+1, time + 1, satisfaction, dp);
        
        // dont pick
        int notPick = recursion(index+1, time, satisfaction, dp);
        return dp[index][time] = Math.max(pick, notPick);
    }
}
