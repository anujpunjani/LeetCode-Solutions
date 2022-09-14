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
    
    private void help(TreeNode root, HashMap<Integer, Integer> map) {
        if(root == null) return;
        
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        
        if(root.left == null && root.right == null) {
            boolean flag = true;
            int odd = 0;
            for(Map.Entry<Integer, Integer> e : map.entrySet()) {
                if(e.getValue() % 2 == 1) {
                    odd++;
                    if(odd > 1) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) count++;
            map.put(root.val, map.getOrDefault(root.val, 0) - 1);
            return;
        }
        
        help(root.left, map);
        help(root.right, map);
        map.put(root.val, map.getOrDefault(root.val, 0) - 1);
    }
    
    public int pseudoPalindromicPaths (TreeNode root) {
        count = 0;
        help(root, new HashMap());
        return count;
    }
}