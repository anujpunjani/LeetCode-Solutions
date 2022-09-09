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
    
    private TreeNode buildTree(int[] postorder, HashMap<Integer, Integer> imap, int inlo, int inhi, int postlo, int posthi) {
        if(inlo > inhi || postlo > posthi) return null;
        
        TreeNode cNode = new TreeNode(postorder[posthi]);
        int index = imap.get(postorder[posthi]);
        int countrhs = inhi - index;
        
        cNode.left = buildTree(postorder, imap, inlo, index - 1, postlo, posthi - countrhs - 1);
        cNode.right = buildTree(postorder, imap, index + 1, inhi, posthi - countrhs, posthi - 1);
        
        return cNode;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> imap = new HashMap();
        for(int i = 0; i < inorder.length; i++)
            imap.put(inorder[i], i);
        return buildTree(postorder, imap, 0, inorder.length - 1, 0, postorder.length - 1);
    }
}