// https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high) {
            int mid = (low + high) / 2;
            
            if(nums[mid] == target)
                return mid;
            
            // left part is sorted
            if(nums[low] <= nums[mid]) {
                // target lies in left part
                if(nums[low] <= target && target <= nums[mid]) {
                    high = mid;
                }
                else{
                    low = mid + 1;    
                }
            }
            // right part is sorted
            else {
                
                // target lies in right part
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
                
            }
        }
        return -1;
    }
}
