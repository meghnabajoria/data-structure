// link : https://leetcode.com/problems/binary-tree-right-side-view/



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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root,list,0);
        return list;
    }
    
    private void traverse(TreeNode root, List<Integer> list, int level) {
        if(root != null) {
            if(list.size() == level)
                list.add(root.val);
            traverse(root.right, list, level + 1);
            traverse(root.left, list, level + 1);
        }
        else{
            return;
        }
    }
}
