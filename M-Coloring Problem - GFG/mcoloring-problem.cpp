// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
// Function to determine if graph can be coloured with at most M colours such
// that no two adjacent vertices of graph are coloured with same colour.

bool can_color(int src, bool graph[101][101], int color, vector<int> &vis) {
    for(int nbr = 0; nbr < vis.size(); nbr++) {
        if(graph[src][nbr] == true && vis[nbr] == color)
            return false;
    }
    return true;
}

bool helper(int idx, bool graph[101][101], int color, vector<int> &vis) {
    
    if(idx == vis.size())
        return true;
    
    for(int c = 0; c < color; c++) {
        if(can_color(idx, graph, c, vis)) {
            vis[idx] = c;
            if(helper(idx+1, graph, color, vis)) return true;
            vis[idx] = -1;
        }
    }
    return false;
}

bool graphColoring(bool graph[101][101], int m, int n) {
   
   vector<int> vis(n, -1);
   
   return helper(0, graph, m, vis);
}

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m, e;
        cin >> n >> m >> e;
        int i;
        bool graph[101][101];
        for (i = 0; i < n; i++) {
            memset(graph[i], 0, sizeof(graph[i]));
        }
        for (i = 0; i < e; i++) {
            int a, b;
            cin >> a >> b;
            graph[a - 1][b - 1] = 1;
            graph[b - 1][a - 1] = 1;
        }
        cout << graphColoring(graph, m, n) << endl;
    }
    return 0;
}
  // } Driver Code Ends