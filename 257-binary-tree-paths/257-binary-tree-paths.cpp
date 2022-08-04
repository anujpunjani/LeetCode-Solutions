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
    vector<string> ans;
    
    void pre(TreeNode* node, string path) {
        if(node == nullptr) return;
        if(node->left == nullptr && node->right == nullptr) {
            path += to_string(node->val);
            ans.push_back(path);
            return;
        }
        
        pre(node->left, path + to_string(node->val) + "->");
        pre(node->right, path + to_string(node->val) + "->");
    }
    
    vector<string> binaryTreePaths(TreeNode* root) {
        pre(root, "");
        return ans;
    }
};