class Solution {
public:
    
    int bfs(vector<vector<int>>& graph) {
        
        queue<pair<int, int>> q;
        q.push({1, 0});
        
        int ans = graph.size();
        
        vector<bool> vis(graph.size(), false);
        
        while(q.size() > 0) {
            
            pair<int, int> front = q.front();
            q.pop();
            
            if(vis[front.first] == true)
                continue;
            
            vis[front.first] = true;
            
            if(front.first == graph.size() - 1) {
                ans = min(ans, front.second);
                continue;
            }
            
            for(int nbr : graph[front.first]) {
                q.push({nbr, front.second + 1});
            }
        }
        
        return ans == graph.size() ? -1 : ans;
    }
    
    int snakesAndLadders(vector<vector<int>>& matrix) {
        int n = matrix.size();
        vector<int> board;        
        board.push_back(0);
        int cell = 1, level = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(level % 2 == 0)
                for(int j = 0; j < n; j++) {
                    if(matrix[i][j] != -1)
                        board.push_back(matrix[i][j]);
                    else
                        board.push_back(cell);
                    cell++;
                }
            else
                for(int j = n -1; j >= 0; j--) {
                    if(matrix[i][j] != -1)
                        board.push_back(matrix[i][j]);
                    else
                        board.push_back(cell);
                    cell++;
                }
            level++;
        }
        
        int size = n * n;
        vector<vector<int>> graph(size + 1);
        
        for(cell = 1 ; cell <= size; cell++) {
            
            for(int d = 1; d <= 6 && cell + d <= size; d++) {
             
                if(board[cell + d] == cell) continue;
                graph[cell].push_back(board[cell + d]);
            }
        }
        
        return bfs(graph);
    }
};