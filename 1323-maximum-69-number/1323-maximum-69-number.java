class Solution {
    public int maximum69Number (int num) {
        String str = Integer.toString(num);
        StringBuilder sb = new StringBuilder(str);
        for(int i=0;i<sb.length();i++) {
            if(str.charAt(i) == '6') {
                sb.setCharAt(i,'9');
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}