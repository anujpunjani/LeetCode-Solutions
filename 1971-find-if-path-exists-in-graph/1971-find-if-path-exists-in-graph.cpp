class Solution {
public:
    
    bool validPath(int src, int dest, vector<vector<int>> &graph, vector<bool> &vis) {
        if(vis[src]) return false;
        if(src == dest) return true;
        vis[src] = true;
        
        for(auto nbr : graph[src]) {
            if(validPath(nbr, dest, graph, vis)) return true;
        }
        
        return false;
    }
    
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        vector<vector<int>> graph(n, vector<int>());
        
        for(auto edge : edges) {
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }
        
        vector<bool> vis(n, false);
        return validPath(source, destination, graph, vis);
    }
};