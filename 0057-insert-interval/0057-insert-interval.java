class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int[] interval = intervals[i];
            if(newInterval[1] < interval[0]) {
                // append the new interval in answer list
                list.add(newInterval);
                // add in list the rest of the old intervals
                newInterval = interval;
            }
            else if(newInterval[0] > interval[1]) {
                // append interval in the answer list
                list.add(interval);
            }
            else 
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
        }
        list.add(newInterval);
        // list to array
        return list.toArray(new int[list.size()][]);
    }
}