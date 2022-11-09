class Solution {
public int rob(int[] nums) {
if(nums.length == 0)
return 0;
int n = nums.length;
if(n == 1)
return nums[n-1];
int prev2 = 0;
int prev1 = 0;
int prev3 = 0;
int prev4 = 0;
for(int i = 0; i < n-1; i++){
int temp = prev1;
prev1 = Math.max(prev2 + nums[i], prev1);
prev2 = temp;
temp = prev3;
prev3 = Math.max(prev4+nums[i+1], prev3);
prev4 = temp;
}
return Math.max(prev1,prev3);
}
}