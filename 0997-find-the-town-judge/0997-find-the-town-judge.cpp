class Solution {
public:
    
    bool isPossible(int judge, vector<unordered_set<int>> &graph) {
        
        for(auto person : graph[judge]) {
            if(graph[person].count(judge)) return false;
        }
        
        return true;
    }
    
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<unordered_set<int>> graph(n+1);
        for(auto t : trust)
            graph[t[1]].insert(t[0]);
        
        for(int i = 1; i < n + 1; i++)
            if(graph[i].size() == n - 1 && isPossible(i, graph)) return i;
            
        return -1;
    }
};