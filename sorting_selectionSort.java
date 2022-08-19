// https://leetcode.com/problems/sort-an-array/submissions/

// will give TLE
class Solution {
    public int[] sortArray(int[] nums) {
        return selectionSort(nums);
    }
    
    private int[] selectionSort(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            // find minimum element
            int minIndex = i;
            int j = i;
            for(j=i+1; j<nums.length; j++) {
                if(nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            
            // swap
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }
}
