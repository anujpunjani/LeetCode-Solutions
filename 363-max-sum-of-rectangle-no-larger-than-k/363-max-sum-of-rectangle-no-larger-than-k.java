class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < rows; i++) {
            
            int[] colSum = new int[cols];
            for(int j = i; j < rows; j++) {
                
                for(int c = 0; c < cols; c++)
                    colSum[c] += matrix[j][c];
                
                max = Math.max(max, find(colSum, k));
            }
            
        }
        
        return max;
    }
    
    private int find(int[] sum, int k) {
        
        int result = Integer.MIN_VALUE;
        int prefixSum = 0;
        TreeSet<Integer> set = new TreeSet();
        set.add(0);
        
        for(int i = 0; i < sum.length; i++) {
            prefixSum += sum[i];
            
            Integer target = set.ceiling(prefixSum - k);
            
            if(target != null) 
                result = Math.max(result, prefixSum - target);
            
            set.add(prefixSum);
        }
        
        return result;
    }
}