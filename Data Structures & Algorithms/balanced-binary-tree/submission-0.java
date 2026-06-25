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
    Boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        findHeight(root);
        return balanced;
    }
    public int findHeight(TreeNode root){
        if(root == null)
            return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);

        int diff = right - left;
        if(diff < -1 || diff > 1)
            balanced = false;

        return Math.max(left, right) + 1;
    }
}
