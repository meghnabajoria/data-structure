class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++) {
            Arrays.fill(dp[i], -1);
        }
        return recursion(0,-1, nums, dp);
    }
    
    private int recursion(int index, int prevIndex, int[] nums, int[][] dp) {
        if(index >= nums.length) {
            return 0;
        }
        if(dp[index][prevIndex+1] != -1) return dp[index][prevIndex+1];
        // not take
        int len = 0 + recursion(index+1, prevIndex, nums,dp);
        // take
        if(prevIndex == -1 || nums[index] > nums[prevIndex]) {
            len = Math.max(len,1 + recursion(index+1, index, nums,dp));
        }
        return dp[index][prevIndex+1] = len;

    }
}