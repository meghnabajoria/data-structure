// https://leetcode.com/problems/diameter-of-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maximum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        checkDepth(root);
        return maximum;
    }
    
    private int checkDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        int lh = checkDepth(root.left);
        int rh = checkDepth(root.right);
        maximum = Math.max(maximum, lh + rh);   
        return 1+Math.max(lh,rh);
    }
}
