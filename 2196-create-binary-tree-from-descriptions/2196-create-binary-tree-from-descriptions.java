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
    public TreeNode createBinaryTree(int[][] descriptions) {
        
        TreeNode root = null;
        
        HashMap<Integer, TreeNode> map = new HashMap();
        
        for(int[] description : descriptions) 
            map.put(description[1], new TreeNode(description[1])); 
            
        for(int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            int isLeft = description[2];
            
            if(root == null && !map.containsKey(parent)) {
                root = new TreeNode(parent);
                map.put(parent, root);
            }
            
            if(isLeft == 1) map.get(parent).left = map.get(child);
            else map.get(parent).right = map.get(child);
            
        }
        
        return root;
    }
}