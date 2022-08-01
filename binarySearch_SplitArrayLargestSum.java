// https://leetcode.com/problems/split-array-largest-sum/submissions/
// striver L3 Binary search master class - https://www.youtube.com/watch?v=Kb3KOTQfjew&t=2340s

class Solution {
    // time complexity is N * log(sum - max + 1)
    public int splitArray(int[] nums, int m) {
        int low = findMaxElement(nums);
        int high = findSum(nums);
        int ans = 0;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            if(numberOfSubArrays(nums,mid) > m) {
                low = mid + 1;
            }
            else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
    
    private int findMaxElement(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        return max;
    }
    
    private int findSum(int[] nums) {
        return Arrays.stream(nums).sum();
    }
    
    private int numberOfSubArrays(int[] nums, int limit) {
        int countNumberOfSubArrays = 1;
        int sum = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] + sum > limit) {
                countNumberOfSubArrays++;
                sum = nums[i];
            }
            else {
                sum = sum + nums[i];
            }
        }
        return countNumberOfSubArrays;
    }
}
