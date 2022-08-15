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
    
    int maxSum = INT_MIN;
    
    int maxPathSumAgain(TreeNode* root) {
        
        if(root == nullptr) return 0;
        
        int left = maxPathSumAgain(root->left);
        int right = maxPathSumAgain(root->right);
        
        int rootIncluded = max(left + root->val, right + root->val);
        int allIncluded = left + root->val + right;
        
        int currMaxPath = max(root->val, max(rootIncluded, allIncluded));
        maxSum = max(maxSum, currMaxPath);
        
        return max(root->val, rootIncluded);
    }
    
    int maxPathSum(TreeNode* root) {
        maxPathSumAgain(root);
        return maxSum;
    }
};