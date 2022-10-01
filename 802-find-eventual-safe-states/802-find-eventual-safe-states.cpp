class Solution {
public:
    bool dfs(int src, vector<int> &vis, vector<vector<int>>& graph) {
        if(vis[src] == 0) return false;
        if(vis[src] == 1) return true;
        vis[src] = 0;

        for(auto nbr : graph[src]) 
            if(dfs(nbr, vis, graph) == false) return false;
        
        vis[src] = 1;
        return true;
    }
 
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int V = graph.size();
        vector<int> vis(V, -1);
        vector<int> ans;
        for(int i = 0; i < V; i++)
            if(dfs(i, vis, graph))
                ans.push_back(i);
        
        return ans;
    }
};