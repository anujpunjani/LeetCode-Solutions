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
    
    class Compare {
        public:
            bool operator() (tuple<TreeNode*, int, int> &t1, tuple<TreeNode*, int, int> &t2) {
                if(get<1>(t1) == get<1>(t2))
                    return get<0>(t1)->val > get<0>(t2)->val;
                
                return get<1>(t1) > get<1>(t2);
            }
    };
    
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        queue<tuple<TreeNode*, int, int>> q;
        unordered_map<int, priority_queue<tuple<TreeNode*, int, int>, vector<tuple<TreeNode*, int, int>>, Compare>> m;
            
        int lv = 0;
        int rv = 0;
        
        q.push(make_tuple(root, 0, 0));
        
        while(q.size() > 0) {
            
            auto front = q.front();
            q.pop();
            
            TreeNode *node = get<0>(front);
            int x = get<1>(front);
            int y = get<2>(front);
            
            lv = min(lv, y);
            rv = max(rv, y);
            
            m[y].push(front);
            
            if(node->left)
                q.push(make_tuple(node->left, x + 1, y - 1));
            
            if(node->right)
                q.push(make_tuple(node->right, x + 1, y + 1));
        }
        
        vector<vector<int>> ans;
        
        for(int i = lv; i <= rv; i++) {
            auto pq = m[i];
            vector<int> temp;
            
            while(pq.size() > 0) {
                auto top = pq.top();
                TreeNode* node = get<0>(top);
                temp.push_back(node->val);
                pq.pop();
            }
            
            ans.push_back(temp);
        }
        
        return ans;
    }
};