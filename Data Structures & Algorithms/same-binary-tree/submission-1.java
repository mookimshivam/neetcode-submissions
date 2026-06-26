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
    Boolean isSame = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        traverse(p,q);
        return isSame;
    }
    // ensure same structure and value
    public void traverse(TreeNode p, TreeNode q){
        // if structure is same we would reach null at same time always
        if(p == null && q == null)
            return;
        // to detect structural difference
        // if structure is different we wont reach null at same time always
        // one tree's null would always come before the other
        if(p == null || q == null){
            isSame = false;
            return;
        }   
        // to detect value difference 
        if(p.val != q.val){
            isSame = false;
            return;
        }
        traverse(p.left,q.left);
        traverse(p.right,q.right);
    }
}
