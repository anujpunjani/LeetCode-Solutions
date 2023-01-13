class Solution {
public:
    
    int ans = 1;
    
    int dfs(int src, int parent, vector<vector<int>> &graph, string &s) {
        
        int longest_path = 1;
        
        for(int nbr : graph[src]) {
            if(nbr == parent) continue; 
            int temp = dfs(nbr, src, graph, s);
            if(s[nbr] != s[src]) { 
                ans = max(ans, longest_path + temp);
                longest_path = max(longest_path, temp + 1);
            }
        }
        
        return longest_path;
    }
    
    int longestPath(vector<int>& parent, string s) {
        int n = parent.size();
        vector<vector<int>> graph(n);
        
        for(int i = 1; i < parent.size(); i++) {
            graph[i].push_back(parent[i]);
            graph[parent[i]].push_back(i);
        }
        
        dfs(0, -1, graph, s);
        return ans;
    }
};