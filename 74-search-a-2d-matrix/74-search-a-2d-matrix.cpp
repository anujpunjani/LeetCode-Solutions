class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int l = 0, r = matrix.size() - 1;
        int row = 0;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] < target) {
                row = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }
        l = 0, r = matrix[0].size() - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(matrix[row][mid] == target)
                return true;
            else if(matrix[row][mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }
};