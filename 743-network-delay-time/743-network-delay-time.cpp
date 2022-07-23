class Solution {
public:
    
    class Pair {
        public:
            int node;
            int weight;

            Pair() {}
        
            Pair(int node, int wt) {
                this->node = node;
                this->weight = wt;
            }

            bool operator()(Pair a, Pair b) {
                return a.weight > b.weight;
            }
    };
    
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        
        n++;
        vector<vector<Pair>> graph(n);
        for(auto time : times) 
            graph[time[0]].push_back(Pair(time[1], time[2]));
        
        
        vector<int> vis(n, -1);
        vis[0] = 0;
        priority_queue<Pair, vector<Pair>, Pair> pq;
        pq.push(Pair(k, 0));
        
        while(pq.size() > 0) {
            Pair top = pq.top();
            pq.pop();
            
            if(vis[top.node] != -1) continue;
            vis[top.node] = top.weight;
            
            for(Pair nbr : graph[top.node])
                pq.push(Pair(nbr.node, nbr.weight + top.weight));
        }
        int ans = 0;
        for(int val : vis) {
            if(val == -1) return -1;
            ans = max(ans, val);
        }
        return ans;
    }
};