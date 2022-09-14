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
    private int result = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        solve(root, new HashSet<Integer>());
        return result;
    }

    private void solve(TreeNode root, HashSet<Integer> set) {
        if (root == null) return;

        if (set.contains(root.val)) set.remove(root.val); 
        else set.add(root.val);

        if (root.left == null && root.right == null) {
            result += (set.size() <= 1) ? 1 : 0;
        }

        solve(root.left, new HashSet<>(set));
        solve(root.right, new HashSet<>(set));
    }
}