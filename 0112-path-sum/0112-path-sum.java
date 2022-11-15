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
    boolean left = false;
    boolean right = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean ans = traverse(root, targetSum, 0);
        return ans;
    }
    
    public boolean traverse(TreeNode root, int target, int sum) {
        
        if(root != null) {
            sum = sum + root.val;
            //System.out.println("sum = " + sum); 
            if(sum == target && root.left == null && root.right == null)
                return true;
             left = traverse(root.left, target, sum);
             right = traverse(root.right, target, sum);
        }
        return left || right;
    }
}