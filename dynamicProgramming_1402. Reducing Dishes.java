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
