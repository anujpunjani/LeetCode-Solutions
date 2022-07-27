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
    int max = 1;
    private int help(TreeNode node) {
        if(node == null) return 0;
        
        int left = node.left != null? help(node.left) : 0;
        int right = node.right != null? help(node.right) : 0;
        
        if(left == 0 && right == 0) return 1;
        
        if(node.left != null && node.right != null && node.val == node.left.val && node.val == node.right.val) {
            max = Math.max(left + right + 1, max);
            return Math.max(left, right) + 1;
        }
        
        if(node.left != null && node.val == node.left.val) {
            max = Math.max(left + 1, max);
            return left + 1;
        }
            
        
        if(node.right != null && node.val == node.right.val) {
            max = Math.max(right + 1, max);
            return right + 1;
        }
        
        return 1;
    }
    
    public int longestUnivaluePath(TreeNode root) {
        help(root);
        return max - 1;
    }
}