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
    vector<double> averageOfLevels(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        vector<double> ans;
        while(q.size() > 0) {
            int size = q.size();
            double sum = 0;
            int level_size = q.size();
            
            while(size --> 0) {
                TreeNode* front = q.front();
                q.pop();
                sum += front->val;
                
                if(front->left) q.push(front->left);
                if(front->right) q.push(front->right);
            }
            
            ans.push_back(sum/level_size);
        }
        return ans;
    }
};