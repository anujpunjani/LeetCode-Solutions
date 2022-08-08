/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    
    vector<TreeNode*> n2r(TreeNode* root, TreeNode* node) {
        
        if(root == nullptr) return vector<TreeNode*>();
        
        if(root == node) {
            return vector<TreeNode*> {node};
        }
        
        vector<TreeNode*> left = n2r(root->left, node);
        if(left.size() > 0) {
            left.push_back(root);
            return left;
        }
            
        
        vector<TreeNode*> right = n2r(root->right, node);
        if(right.size() > 0) {
            right.push_back(root);
            return right;
        }
        
        return vector<TreeNode*>();
    }
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> ppath = n2r(root, p);
        reverse(ppath.begin(), ppath.end());
        vector<TreeNode*> qpath = n2r(root, q);
        reverse(qpath.begin(), qpath.end());
        
        int i = 0;
        while(i < min(ppath.size(), qpath.size()) && ppath[i] == qpath[i]) i++;
        
        return ppath[i - 1];
    }
};