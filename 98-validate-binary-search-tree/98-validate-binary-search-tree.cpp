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
    
    bool help(TreeNode* root, long min, long max) {
        
        if(root == nullptr) return true;
        
        if(root->val > min && root->val < max) {
            bool left = help(root->left, min, root->val);
            bool right = help(root->right, root->val, max);
            
            return left && right;
        }
        
        return false;
    }
    
    bool isValidBST(TreeNode* root) {
        return help(root, LONG_MIN, LONG_MAX);
    }
};