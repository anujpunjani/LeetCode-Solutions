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
    
    int index = 0;
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int left, int right) {
        
        if(left > right) return null;
        
        TreeNode cNode = new TreeNode(preorder[index++]);
        
        int idx = 0;
        
        for(int i = left; i <= right; i++)
            if(inorder[i] == cNode.val) {
                idx = i;
                break;
            }
        
        cNode.left = buildTree(preorder, inorder, left, idx - 1);
        cNode.right = buildTree(preorder, inorder, idx + 1, right);
        
        return cNode;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }
}