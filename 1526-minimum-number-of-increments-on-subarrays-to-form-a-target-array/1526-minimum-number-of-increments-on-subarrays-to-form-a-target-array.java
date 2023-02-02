class Solution {
    public int minNumberOperations(int[] target) {
        int res = 0, pre = 0;
        for (int a: target) {
            res += Math.max(a - pre, 0);
            System.out.println("res = " + res);
            pre = a;
        }
        return res;
    }
}