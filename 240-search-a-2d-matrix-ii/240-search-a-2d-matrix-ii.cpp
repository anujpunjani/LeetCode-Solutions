class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int n = matrix.size() - 1, m = matrix[0].size() - 1;
        int row = 0, col = m;

        while(col >= 0 && row <= n) {
            if(matrix[row][col] == target)
                return true;
            
            if(matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
    }
};