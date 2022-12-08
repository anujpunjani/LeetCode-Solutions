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
    
    void dfs(TreeNode* root, vector<int> &store) {
        if(root == nullptr) return;
        if(root->left == nullptr && root->right == nullptr) {
            store.push_back(root->val);
            return;
        }
        
        dfs(root->left, store);
        dfs(root->right, store);
    }
    
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> s1;
        vector<int> s2;
        dfs(root1, s1);
        dfs(root2, s2);
        return s1 == s2;
    }
};