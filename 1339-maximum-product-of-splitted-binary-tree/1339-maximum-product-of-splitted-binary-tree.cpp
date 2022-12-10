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
    
    int sumOfTree(TreeNode* root, vector<int> &sums) {
        if(root == nullptr) return 0;
        
        int left = sumOfTree(root->left, sums);
        int right = sumOfTree(root->right, sums);
        
        int sum = left + root->val + right;
        sums.push_back(sum);
        return sum;
    }
    
    int maxProduct(TreeNode* root) {
        vector<int> sums;
        long long int total_sum = sumOfTree(root, sums);
        long long int max_e = INT_MIN;
        for(int sum : sums)
            max_e = max(max_e, sum * (total_sum - sum));
        return max_e % mod;
    }
};