class Solution {
public:
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        vector<set<int>> graph(n);
        
        for(auto edge : edges) {
            graph[edge[0]].insert(edge[1]);
            graph[edge[1]].insert(edge[0]);
        }
        
        vector<int> nodes_below(n, 0);
        vector<int> ans(n, 0);
        
        helper1(graph, nodes_below, ans, 0, -1);
        helper2(graph, nodes_below, ans, 0, -1);
        
        return ans;
    }
    
    void helper1(vector<set<int>>& graph, vector<int>& nodes_below, vector<int>& edges_below, int src, int parent)     {
            
        for(auto nbr : graph[src]) {
            
            if(nbr != parent) {
                
                helper1(graph, nodes_below, edges_below, nbr, src);
                nodes_below[src] += nodes_below[nbr];
                edges_below[src] += edges_below[nbr] + nodes_below[nbr];
                
            }
        }
        
        nodes_below[src]++;
    }
    
    void helper2(vector<set<int>>& graph, vector<int>& nodes, vector<int>& ans, int src, int parent)     {
            
        for(auto nbr : graph[src]) {
            
            if(nbr != parent) {
                ans[nbr] = ans[src] + nodes.size() - 2*nodes[nbr];
                helper2(graph, nodes, ans, nbr, src);
            }
            
        }
    }
    
};