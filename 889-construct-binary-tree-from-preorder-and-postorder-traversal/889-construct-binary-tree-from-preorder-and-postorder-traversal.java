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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < postorder.length; i++)
            map.put(postorder[i], i);
        
        return constructFromPrePost(preorder, postorder, map, 0, preorder.length-1, 0, postorder.length-1);
    }
    
    private TreeNode constructFromPrePost(int[] preorder, int[] postorder, HashMap<Integer, Integer> map, int prelo, int prehi, int postlo, int posthi) {
        
        if(prelo > prehi || postlo > posthi)
            return null;
        
        TreeNode node = new TreeNode(preorder[prelo]);
        
        if(prelo + 1 <= prehi) {
            
            int postidx = map.get(preorder[prelo + 1]);
            int count = postidx - postlo + 1;
            
            node.left = constructFromPrePost(preorder, postorder, map, prelo + 1, prelo + count, postlo, postidx);
            node.right = constructFromPrePost(preorder, postorder, map, prelo + count+1, prehi, postidx+1, posthi-1);
            
        }
        
        return node;
    }
    
}