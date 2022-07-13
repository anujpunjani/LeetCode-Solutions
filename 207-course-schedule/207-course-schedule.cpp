class Solution {
public:
    
    bool dfs(int src, vector<vector<int>> &graph, vector<int> &vis) {
        
        if(vis[src] == 1) return true;
        if(vis[src] == 2) return false;
        
        vis[src] = 1;
        for(int nbr : graph[src])
            if(dfs(nbr, graph, vis))
                return true;
                
        vis[src] = 2;
        return false;
    }
    
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        vector<vector<int>> graph(numCourses);
        
        for(auto v : prerequisites)
            graph[v[1]].push_back(v[0]);
        
        vector<int> vis(numCourses, 0);
        for(int i = 0; i < numCourses; i++)
            if(dfs(i, graph, vis))
                return false;
        
        return true;
    }
};