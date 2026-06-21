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
    // using recurrence
    public int maxDepth(TreeNode root) {
        // when at end edge 0
        if(root == null)
            return 0;
        
        // will get left-subtree depth
        int leftDepth = maxDepth(root.left);
        // will get right sub-tree depth
        int rightDepth = maxDepth(root.right);

        // add 1 to max among 2 giving depth from root
        return Math.max(leftDepth, rightDepth) + 1; 
    }
}
