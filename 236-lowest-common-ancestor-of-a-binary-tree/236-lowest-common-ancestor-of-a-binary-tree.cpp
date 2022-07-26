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
    
    vector<TreeNode*> n2r(TreeNode* node, TreeNode* p) {
        if(node == nullptr) return vector<TreeNode*>();
        
        if(node == p) return vector<TreeNode*> {node};
        
        vector<TreeNode*> left = n2r(node->left, p);
        if(left.size() > 0) {
            left.push_back(node);
            return left;
        }
        vector<TreeNode*> right = n2r(node->right, p);
        if(right.size() > 0) {
            right.push_back(node);
            return right;
        }
        
        return vector<TreeNode*>();
    }
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> ppath = n2r(root, p);
        vector<TreeNode*> qpath = n2r(root, q);
        reverse(ppath.begin(), ppath.end());
        reverse(qpath.begin(), qpath.end());
        int i = 0, j = 0;
        while(i < ppath.size() && j < qpath.size() && ppath[i] == qpath[j])
            i++, j++;
        return ppath[i-1];
    }
};