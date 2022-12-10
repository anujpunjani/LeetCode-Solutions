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
    
    int mod = (int)1e9 + 7;
    
    int sumOfTree(TreeNode* root, unordered_map<TreeNode*, int> &m) {
        if(root == nullptr) return 0;
        
        int left = sumOfTree(root->left, m);
        int right = sumOfTree(root->right, m);
        
        int sum = left + root->val + right;
        m[root] = sum;
        return sum;
    }
    
    void maxProduct(TreeNode* root, unordered_map<TreeNode*, int> &m, long long int &max_e, long long int total_sum) {
        if(root == nullptr) return;
        
        int left = m[root->left];
        int right = m[root->right];
        
        max_e = max(max_e, 
                    max(
                        (total_sum - left) * left, 
                        (total_sum - right) * right
                   )
                   );
        
        maxProduct(root->left, m, max_e, total_sum);
        maxProduct(root->right, m, max_e, total_sum);
    }
    
    int maxProduct(TreeNode* root) {
        unordered_map<TreeNode*, int> m;
        long long int total_sum = sumOfTree(root, m);
        long long int max_e = INT_MIN;
        maxProduct(root, m, max_e, total_sum);
        return max_e % mod;
    }
};