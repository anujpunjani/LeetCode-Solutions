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
    bool isEvenOddTree(TreeNode* root) {
        queue<TreeNode*> q;
        q.push(root);
        
        int level = 0;
            
        while(q.size() > 0) {
            
            int size = q.size();
            int prev = level == 1? INT_MAX : INT_MIN;

            while(size --> 0) {
                
                TreeNode* front = q.front();
                q.pop();
                
                if(level%2 == 0) {
                    // cout << front->val << " " << prev << endl; 
                    if(front->val%2 != 1 || front->val <= prev)
                        return false;
                }else{
                    // cout << front->val << " " << prev << endl; 
                    if(front->val%2 != 0 || front->val >= prev)
                        return false;
                }
                
                if(front->left)
                    q.push(front->left);
                
                if(front->right) 
                    q.push(front->right);
                
                prev = front->val;
            }
            
            level = level == 1? 0 : 1;
        }
        
        return true;
    }
};