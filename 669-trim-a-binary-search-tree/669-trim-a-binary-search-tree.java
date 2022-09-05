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
    
    private TreeNode delete(TreeNode root, int key) {
        
        if(root == null) return null;
        
        if(root.val == key) {
            if(root.left == null && root.right == null)
                return null;
            else if(root.left == null) 
                return root.right;
            else if(root.right == null) 
                return root.left;
            else {
                TreeNode ios = root.right;
                while(ios.left != null) ios = ios.left;
                root.val = ios.val;
                delete(root, root.val);
                return root;
            }
        } else if(root.val < key)
            root.right = delete(root.right, key);
        else
            root.left = delete(root.left, key);
        
        return root;
    }
    
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        if(root.val < low || root.val > high) {
            root = delete(root, root.val);
        }
        
        return root;
    }
}