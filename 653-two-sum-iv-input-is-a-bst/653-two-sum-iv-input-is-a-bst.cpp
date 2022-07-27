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
    void inorder(TreeNode* node, vector<int> &store) {
        if(node == nullptr) return;
        inorder(node->left, store);
        store.push_back(node->val);
        inorder(node->right, store);
    }
    bool findTarget(TreeNode* root, int k) {
        vector<int> store; 
        inorder(root, store);
        int i = 0, j = store.size() - 1;
        while(i < j) {
            int tot = store[i] + store[j];
            if(tot == k) return true;
            if(tot > k) j--;
            else i++;
        }
        return false;
    }
};