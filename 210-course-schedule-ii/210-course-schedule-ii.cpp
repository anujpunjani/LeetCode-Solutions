class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> graph(numCourses);
        
        for(auto v : prerequisites) 
            graph[v[1]].push_back(v[0]);
        
        vector<bool> vis(numCourses, false);
        
        queue<int> q;
        vector<int> incoming(numCourses, 0);
        
        for(int i = 0; i < numCourses; i++)
            for(int j : graph[i])
                incoming[j]++;
        
        for(int i = 0; i < numCourses; i++)
            if(incoming[i] == 0)
                q.push(i);
        
        vector<int> ans;
        int visited = 0;
        
        while(q.size() > 0) {
            
            int src = q.front();
            q.pop();
            ans.push_back(src);
            visited++;
            
            for(int nbr : graph[src]) {
                incoming[nbr]--;
                if(incoming[nbr] == 0)
                    q.push(nbr);
            }
            
        }
        
        if(visited == numCourses)
            return ans;
        
        return vector<int>();
    }
};