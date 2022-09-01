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
    
    int count = 0;
    
    private void goodNodes(TreeNode root, int prev) {
        if(root == null) return;
        
        if(root.val >= prev) count++;
        
        goodNodes(root.left, Math.max(root.val, prev));
        goodNodes(root.right, Math.max(root.val, prev));
    }
    
    public int goodNodes(TreeNode root) {
        goodNodes(root, Integer.MIN_VALUE);
        return count;
    }
}