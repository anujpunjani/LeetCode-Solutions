class Solution {
public:
    int maxPoints(vector<vector<int>>& points) {
        int n = points.size();
        if(n <= 2) return n;
        int max_points = 2;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int total_points = 2;
                for(int k = 0; k < n; k++) {
                    
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    
                    if(k != i && k != j && (y2-y1)*(x3-x2) == (y3-y2)*(x2-x1))
                        total_points++;
                }
                max_points = max(max_points, total_points);
            }
        }
        
        return max_points;
    }
};