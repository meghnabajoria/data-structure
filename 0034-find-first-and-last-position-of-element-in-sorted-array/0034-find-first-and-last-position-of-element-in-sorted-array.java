class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = bs(nums, target, true);
        int right = bs(nums, target, false);
        return new int[] {left,right};
    }
    
    private int bs (int[] nums, int target, boolean left) {
        int start = 0;
        int end = nums.length - 1;
        int i = -1;

        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] < target) {
                start = mid + 1;
            }
            else if(nums[mid] > target) {
                end = mid - 1;
            }
            else {
                i = mid;
                if(left)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return i;
    }
}