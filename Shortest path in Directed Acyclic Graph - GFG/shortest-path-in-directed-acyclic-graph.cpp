//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  private:
    void dfs(int src, vector<int> &topo, vector<bool> &vis, vector<vector<pair<int, int>>> &graph, int &index) {
        if(vis[src]) return;
        vis[src] = true;
        
        for(auto nbr : graph[src])
            dfs(nbr.first, topo, vis, graph, index);
        
        topo[index--] = src;
    }
  
  public:
     vector<int> shortestPath(int N,int M, vector<vector<int>>& edges){
        vector<vector<pair<int, int>>> graph(N);
        
        for(auto edge : edges) {
            graph[edge[0]].push_back({edge[1], edge[2]});
        }
        
        vector<int> topo(N);
        vector<bool> vis(N, false);
        
        int index = N - 1;
        for(int i = 0; i < N; i++)
            dfs(i, topo, vis, graph, index);
        
        vector<int> ans(N, INT_MAX);
        
        queue<pair<int, int>> q;
        q.push({0, 0});
        
        while(!q.empty()) {
            auto front = q.front();
            q.pop();
            ans[front.first] = min(front.second, ans[front.first]);
            
            for(auto nbr : graph[front.first])
                q.push({nbr.first, nbr.second + front.second});
                
        }
        
        for(int i = 0; i < N; i++)
            if(ans[i] == INT_MAX) ans[i] = -1;
        
        return ans;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> edges;
        for(int i=0; i<m; ++i){
            vector<int> temp;
            for(int j=0; j<3; ++j){
                int x; cin>>x;
                temp.push_back(x);
            }
            edges.push_back(temp);
        }
        Solution obj;
        vector<int> res = obj.shortestPath(n, m, edges);
        for (auto x : res) {
            cout << x << " ";
        }
        cout << "\n";
    }
}

// } Driver Code Ends