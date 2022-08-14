// https://leetcode.com/problems/balanced-binary-tree/
// https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=16

class Solution {
    public boolean isBalanced(TreeNode root) {
      return depth(root) != -1;
        
    }
    
    private int depth(TreeNode root) {
        if(root == null)
            return 0;
        int lh = depth(root.left);
        if(lh == -1)
            return -1;
        
        int rh = depth(root.right);
        if(rh == -1)
            return -1;
        
        if(Math.abs(lh-rh) > 1)
            return -1;
       
        return Math.max(lh,rh) + 1;
    }
}
