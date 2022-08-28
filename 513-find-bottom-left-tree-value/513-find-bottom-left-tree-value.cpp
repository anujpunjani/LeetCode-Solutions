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
    
    int maxH = -1;
    int value = 0;
    
    void help(TreeNode* root, int depth) {
        if(root == nullptr) return;
        
        if(maxH < depth) {
            maxH = depth;
            value = root->val;
        }
        
        help(root->left, depth + 1);
        help(root->right, depth + 1);
    }
    
    int findBottomLeftValue(TreeNode* root) {
        help(root, 0);
        return value;
    }
};