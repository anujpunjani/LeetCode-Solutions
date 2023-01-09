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
    vector<int> preorderTraversal(TreeNode* root) {
        
        vector<int> ans;
        
        if(root == nullptr) return ans;
        
        stack<pair<TreeNode*, int>> stk;
        // pair<Node, state>
        
        stk.push({root, 0});
        
        while(stk.size() > 0) {
            
            stk.top().second++;
            
            if(stk.top().second == 1) {
                ans.push_back(stk.top().first->val);
                
            } else if(stk.top().second == 2) {
       
                if(stk.top().first->left) {
                    stk.push({stk.top().first->left, 0});
                }
                
            } else if(stk.top().second == 3) {

                if(stk.top().first->right) {
                    stk.push({stk.top().first->right, 0});
                }
                
            } else {
                stk.pop();
            }
            
        }
        
        return ans;
    }
};