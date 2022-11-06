class Solution {
    public String orderlyQueue(String s, int k) {
        if(k>1) {
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
        // else {
        //     String min = s;
        //     String str = s + s;
        //     int s_len = s.length();
        //     System.out.println("str : " + str);
        //     for(int i=0;i<str.length();i++) {
        //         System.out.println(i + s_len);
        //         if(i + s_len < str.length() - 1) 
        //             System.out.println("substring:" + str.substring(i, i + s_len));
        //             if(str.substring(i, i + s_len).compareTo(min) < 0) {
        //             min = str.substring(i, i + s_len);
        //         }
        //     }
        //     return min;
        // }
        else {
            String ans  = s;
            for(int i=0;i< s.length(); i++){
                System.out.println("s.substring(1) : " + s.substring(1));
                System.out.println("s.substring(0,1) : " + s.substring(0,1));
                s = s.substring(1) + s.substring(0,1);
                if(ans.compareTo(s) >0){
                    ans = s;
                }
            }
            return ans;
        }
    }
}