/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    int depth(TreeNode* node) {
        if(node == nullptr) return 0;
        return max(depth(node->left), depth(node->right)) + 1;
    }
    
    TreeNode* helper(TreeNode* node) {
        if(node == nullptr) return node;
        
        int left = depth(node->left);
        int right = depth(node->right); 
        
        if(left == right) return node;
        else if(left > right) return helper(node->left);
        
        return helper(node->right);
    }
    
    TreeNode* lcaDeepestLeaves(TreeNode* root) {
        return helper(root);
    }
};