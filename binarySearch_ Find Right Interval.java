// https://leetcode.com/problems/find-right-interval/
// https://www.youtube.com/watch?v=BWZmkS0ed-o


class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        if(n == 1)
            return new int[]{-1};
        
        TreeMap<Integer,Integer> treeMap = new TreeMap();
        for(int i=0;i<n;i++)
            treeMap.put(intervals[i][0], i);
        
        int[] result = new int[intervals.length];
        for(int i=0;i<n;i++){
            Integer key = treeMap.ceilingKey(intervals[i][1]);
            if(key == null)
                result[i] = -1;
            else
                result[i] = treeMap.get(key);
        }
        return result;
    }
}
