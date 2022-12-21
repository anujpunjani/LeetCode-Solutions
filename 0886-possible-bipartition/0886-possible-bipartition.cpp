class Solution {
public:
    
    bool dfs(int src, int set, vector<vector<int>>& graph, vector<int> &vis) {
        
        if(vis[src] != -1) {
            if(vis[src] != set % 2) return false;
            return true;
        }
        
        vis[src] = set % 2;
        
        for(int nbr : graph[src])
            if(dfs(nbr, set + 1, graph, vis) == false)
                return false;
        return true;
    }
    
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        
        vector<vector<int>> graph(n + 1, vector<int>());
        
        for(auto dislike : dislikes) {
            graph[dislike[0]].push_back(dislike[1]);
            graph[dislike[1]].push_back(dislike[0]);
        }
        
        vector<int> vis(graph.size(), -1);
        
        for(int i = 0; i < graph.size(); i++)
            if(vis[i] == -1 && dfs(i, 0, graph, vis) == false)
                return false;
        
        return true;
    }
};