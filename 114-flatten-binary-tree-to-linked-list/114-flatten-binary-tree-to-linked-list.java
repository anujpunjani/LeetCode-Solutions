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
    
    private void store(TreeNode root, ArrayList<TreeNode> space) {
        
        if(root == null) return;
        
        space.add(root);
        store(root.left, space);
        store(root.right, space);
    }
    
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> space = new ArrayList<>();
        store(root, space);
        
        int size = space.size() - 1;
        int i = 1;
        while(size --> 0) {
            root.right = space.get(i);
            root.left = null;
            root = root.right;
            i++;
        }
        
    }
}