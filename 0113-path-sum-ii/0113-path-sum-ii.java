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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        traverse(root, targetSum, list, 0, new ArrayList<>());
        return list;
    }
    
    private void traverse(TreeNode root, int targetSum, List<List<Integer>> list, int sum, List<Integer> subList) {
        if(root != null) {
            sum = sum + root.val;
            subList.add(root.val);
            //System.out.println("sum = " + sum);
            if(sum == targetSum && root.left == null && root.right == null) {
                list.add(new ArrayList<Integer>(subList));

            }
            else {
                traverse(root.left, targetSum, list, sum, subList);
                traverse(root.right, targetSum, list, sum, subList);
            }
            subList.remove(subList.size()-1);
        }
        else
            return;
    }
}