class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        sort(points.begin(), points.end(), [](auto &a, auto &b) {
           return a[1] < b[1]; 
        });
        
        int arrows = 1, reach = points[0][1];
        
        for(int i = 1; i < points.size(); i++) {
            
            if(points[i][0] > reach) {
                arrows++;
                reach = points[i][1];
            }
            
        }
        
        return arrows;
    }
};