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
    vector<int> largestValues(TreeNode* root) {
        
        vector<int> ans;
        
        if(!root) return ans;
        
        queue<TreeNode*> q;
        q.push(root);
        
        int max_ele = root->val;
        
        while(q.size() > 0) {
            
            ans.push_back(max_ele);    
            int size = q.size();
            max_ele = INT_MIN;
            
            while(size --> 0) {
                
                TreeNode* curr = q.front();
                q.pop();
                
                
                
                if(curr->left) {
                    max_ele = max(max_ele, curr->left->val);
                    q.push(curr->left);
                }
                
                
                if(curr->right) {
                    max_ele = max(max_ele, curr->right->val);
                    q.push(curr->right);
                }
            }
        }
        
        return ans;
    }
};