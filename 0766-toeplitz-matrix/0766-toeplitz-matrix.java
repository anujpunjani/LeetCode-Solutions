class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        for(int gap = 0; gap < matrix[0].length; gap++) {
            int num = matrix[0][gap];
            for(int i = 0, j = gap; i < matrix.length && j < matrix[0].length; i++, j++)
                if(matrix[i][j] != num) return false;
        } 

        for(int gap = 1; gap < matrix.length; gap++) {
            int num = matrix[gap][0];
            for(int i = gap, j = 0; i < matrix.length && j < matrix[0].length; i++, j++)
                if(matrix[i][j] != num) return false;
        }
        
        return true;
    }
}