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
    int countNodes(TreeNode* root) {
        if(root == nullptr) return 0;
        
        TreeNode *left = root->left;
        TreeNode *right = root->right;
        
        int leftHeight = 1;
        int rightHeight = 1;
        
        while(left != nullptr) {
            leftHeight++;
            left = left->left;
        }
        
        while(right != nullptr) {
            rightHeight++;
            right = right->right;
        }
        
        if(leftHeight == rightHeight)
            return (1 << leftHeight) - 1;
        
        return countNodes(root->left) + countNodes(root->right) + 1;
    }
};