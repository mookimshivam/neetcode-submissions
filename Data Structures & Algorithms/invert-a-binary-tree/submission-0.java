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
    // swap all the left node with its respective right node
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        if(root != null)
            stack.push(root);

        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            TreeNode left = temp.left;
            TreeNode right = temp.right;

            if(left != null)
                stack.push(left);
            if(right != null)
                stack.push(right);

            temp.left = right;
            temp.right = left;
        }   
        return root;
    }
}
