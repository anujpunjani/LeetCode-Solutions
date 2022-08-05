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
    vector<int> rightSideView(TreeNode* root) {

        queue<TreeNode*> q;
        q.push(root);
        vector<int> ans;
        
        if(root == nullptr) return ans;
        
        while(q.size() > 0) {
            int size = q.size();
            ans.push_back(q.front()->val);
            while(size --> 0) {
                TreeNode* front = q.front();
                q.pop();
                if(front->right)
                    q.push(front->right);
                if(front->left)
                    q.push(front->left);
            }
        }
        
        return ans;
    }
};