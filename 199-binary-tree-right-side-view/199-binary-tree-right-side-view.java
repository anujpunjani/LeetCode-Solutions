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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        ArrayDeque<TreeNode> q = new ArrayDeque();
        
        q.add(root);
        
        while(q.size() > 0) {
            
            TreeNode temp = q.peekLast();
            ans.add(temp.val);
            
            int size = q.size();
            
            while(size --> 0) {
                
                TreeNode curr = q.remove();
                if(curr.left != null)
                    q.add(curr.left);
                
                if(curr.right != null)
                    q.add(curr.right);
                
            }
            
        }
        return ans;
    }
}