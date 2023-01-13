class Solution {
public:
    
    vector<int> dfs(int src, int parent, vector<vector<int>> &graph, unordered_map<int, char> &nodes, vector<int> &ans) {
        
        vector<int> freq(26, 0);
        freq[nodes[src]-'a']++;
        
        for(int nbr : graph[src]) {
            if(nbr == parent) continue;
            vector<int> temp = dfs(nbr, src, graph, nodes, ans);
            for(int i = 0; i < temp.size(); i++)
                freq[i] += temp[i];
        }
        
        ans[src] = freq[nodes[src]-'a'];
        return freq;
    }
    
    vector<int> countSubTrees(int n, vector<vector<int>>& edges, string labels) {
        vector<vector<int>> graph(n);
        unordered_map<int, char> nodes;
        
        for(int i = 0; i < labels.size(); i++)
            nodes[i] = labels[i];
        
        for(auto edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        
        vector<int> ans(n, 0);
        dfs(0, -1, graph, nodes, ans);
        
        return ans;
    }
};