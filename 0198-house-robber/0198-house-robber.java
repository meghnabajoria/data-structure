class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int money = find(dp, nums, nums.length - 1);
        return money;
    }
    
    private int find(int[] dp, int[] nums, int index) {
        if(index < 0)
            return 0;
        if(index == 0)
            return nums[index];
        
        if(dp[index] != -1)
            return dp[index];
        int pick = nums[index] + find(dp, nums, index-2);
        
        int notPick = 0 + find(dp, nums, index - 1);
        return dp[index] = Math.max(pick, notPick);
    }
}