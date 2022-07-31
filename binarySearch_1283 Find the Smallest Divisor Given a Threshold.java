// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
//explain https://www.youtube.com/watch?v=Kb3KOTQfjew

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int high = findMaxElement(nums);
        int ans = high;
        int low = 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(findSumAfterDiv(nums, mid) <= threshold) {
                //System.out.println("mid : " + mid);
                //System.out.println("findSumAfterDiv(nums, mid) :" + findSumAfterDiv(nums, mid));
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;  
    }
    
    private int findMaxElement(int[] nums) {
       Arrays.sort(nums);
        return nums[nums.length-1];
    }
    
    private int findSumAfterDiv(int[] nums, int mid) {
        int sum = 0;
        for(int i = 0;i < nums.length; i++) {
          sum = sum + (nums[i]/mid);
            if(nums[i]%mid != 0)
                sum = sum + 1;
        }
        return sum;
    }
}
