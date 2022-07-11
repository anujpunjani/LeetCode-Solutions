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
    List<Integer> ans = new ArrayList<>();
    
    private void rightSide(TreeNode root, int depth) {
        if(root == null) return;
        
        if(depth == ans.size()) ans.add(root.val);
        
        rightSide(root.right, depth + 1);
        rightSide(root.left, depth + 1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        rightSide(root, 0);
        return ans;
    }
}