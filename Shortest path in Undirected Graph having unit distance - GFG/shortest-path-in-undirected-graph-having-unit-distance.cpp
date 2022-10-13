//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    vector<int> shortestPath(vector<vector<int>>& edges, int N,int M, int src){
        vector<vector<int>> graph(N);
        
        for(auto edge : edges) {
            graph[edge[1]].push_back(edge[0]);
            graph[edge[0]].push_back(edge[1]);
        }
        
        queue<pair<int, int>> q;
        q.push({src, 0});
        vector<int> ans(N, -1);
        
        while(!q.empty()) {
            auto front = q.front();
            q.pop();
            
            if(ans[front.first] != -1) continue;
            ans[front.first] = front.second;
            
            for(int nbr : graph[front.first])
                q.push({nbr, front.second + 1});
            
        }
        
        return ans;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m; cin >> n >> m;
        vector<vector<int>> edges;

        for (int i = 0; i < m; ++i) {
            vector<int> temp;
            for(int j=0; j<2; ++j){
                int x; cin>>x;
                temp.push_back(x);
            }
            edges.push_back(temp);
        }

        int src; cin >> src;

        Solution obj;

        vector<int> res = obj.shortestPath(edges, n, m, src);

        for (auto x : res){
            cout<<x<<" ";
        }
        cout << "\n";
    }
}

// } Driver Code Ends