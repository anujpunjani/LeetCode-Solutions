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
    
    void pathSum(TreeNode root, int targetSum, int currentSum, ArrayList<Integer> list, List<List<Integer>> ans) {
        
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            
            if(currentSum + root.val == targetSum) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.addAll(list);
                temp.add(root.val);
                ans.add(temp);
            }
                
            return;
        }
        
        list.add(root.val);
        pathSum(root.left, targetSum, currentSum + root.val, list, ans);
        pathSum(root.right, targetSum, currentSum + root.val, list, ans);
        list.remove(list.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        
        pathSum(root, targetSum, 0, new ArrayList<>(), ans);
        
        return ans;
    }
}