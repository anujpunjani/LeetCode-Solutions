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
    public TreeNode reverseOddLevels(TreeNode root) {
        Stack<TreeNode> mainS = new Stack();
        mainS.push(root);
        
        int level = 1;
        while(mainS.size() > 0) {
            Stack<TreeNode> childS = new Stack();
            ArrayList<TreeNode> list = new ArrayList<>();
            
            while(mainS.size() > 0) {
                TreeNode top = mainS.pop();
                
                if(level % 2 == 1) {
                    if(top.right != null){ childS.push(top.right); list.add(top.right); }
                    if(top.left != null){ childS.push(top.left); list.add(top.left); }
                } else {
                    if(top.left != null) childS.push(top.left);
                    if(top.right != null) childS.push(top.right);
                }
            }
            
            if(list.size() > 0)
                for(int i = 0, j = list.size() - 1; i < j; i++, j--) {
                    int temp = list.get(i).val;
                    list.get(i).val = list.get(j).val;
                    list.get(j).val = temp;
                }
            
            mainS = childS;
            level++;
        }
        
        return root;
    }
}