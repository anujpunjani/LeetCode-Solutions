class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<pair<int, int>, int>> q;
        int n = grid.size(), m = grid[0].size();
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < m; j++) 
                if(grid[i][j] == 2)
                    q.push({{i, j}, 0});
        
        int minTime = 0;
        vector<pair<int, int>> calls{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(q.size() > 0) {
            
            auto front = q.front();
            q.pop();
            int r = front.first.first, c = front.first.second;
            if(grid[r][c] == 3) continue;
            grid[r][c] = 3;
            
            minTime = max(minTime, front.second);
            
            for(int i = 0; i < 4; i++) {
                
                int nr = r + calls[i].first;
                int nc = c + calls[i].second;
                
                if(nr < 0 || nc < 0 || nr == grid.size() || nc == grid[0].size() || grid[nr][nc] == 3 || grid[nr][nc] == 0)
                    continue;
                
                q.push({{nr, nc}, front.second + 1});
            }
            
        }
        
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < m; j++) 
                if(grid[i][j] == 1)
                    return -1;
        
        return minTime;
    }
};