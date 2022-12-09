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
    
    void maxAncestorDiff(TreeNode* root, int min_e, int max_e, int &max_diff) {
        if(root == nullptr) return;
        
        if(min_e != INT_MAX && max_e != INT_MIN) {
            max_diff = max(max_diff, abs(root->val - min_e));
            max_diff = max(max_diff, abs(root->val - max_e));
        }
        
        min_e = min(min_e, root->val);
        max_e = max(max_e, root->val);
        
        maxAncestorDiff(root->left, min_e, max_e, max_diff);
        maxAncestorDiff(root->right, min_e, max_e, max_diff);
    }
    
    int maxAncestorDiff(TreeNode* root) {
        int max_diff = 0;
        maxAncestorDiff(root, INT_MAX, INT_MIN, max_diff);
        return max_diff;
    }
};