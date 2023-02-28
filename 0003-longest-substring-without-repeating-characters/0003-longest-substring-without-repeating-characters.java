class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max_len = 0;
        //int curr_length = 0;
        int i=0;
        int j=0;
        for(j=0;j<s.length();j++){
            if(set.contains(s.charAt(j))) {
                while(i<j && set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                }
                
            }
            set.add(s.charAt(j));
            //curr_length = j-1+1;
            max_len = Math.max(max_len, j-i+1);
        }
        return max_len;
    }
}