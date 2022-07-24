class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        
        int n = matrix.size() - 1, m = matrix[0].size() - 1;
        int row = 0, col = m;
        
        if(matrix[row][col] == target)
            return true;
        
        while(col > 0 && row < n) {
            // cout << matrix[row][col];
            if(matrix[row][col - 1] == target || matrix[row + 1][col] == target)
                return true;
            
            if(matrix[row][col - 1] < target && matrix[row + 1][col] < target) {
                if(matrix[row][col - 1] > matrix[row + 1][col])
                    col = col - 1;
                else
                    row = row + 1;
                
            } else if (matrix[row][col - 1] > target && matrix[row + 1][col] > target) {
                if(matrix[row][col - 1] < matrix[row + 1][col])
                    col = col - 1;
                else
                    row = row + 1;
            } else if(matrix[row][col - 1] > target && matrix[row + 1][col] < target) {
                row = row + 1;
            } else if(matrix[row][col - 1] < target && matrix[row + 1][col] > target) {
                col = col - 1;
            }
        }
        while(row <= n) {
            if(matrix[row][0] == target)
                return true;
            row++;
        }
        while(col >= 0) {
            if(matrix[n][col] == target)
                return true;
            col--;
        }
        return false;
    }
};