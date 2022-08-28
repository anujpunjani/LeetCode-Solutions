class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        for(int gap = 0; gap < m; gap++) {
            
            List<Integer> store = new ArrayList<>();
            for(int i = 0, j = gap; i < n && j < m; i++, j++)
                store.add(mat[i][j]);
            
            Collections.sort(store);
            // System.out.println(store);

            for(int i = 0, j = gap; i < n && j < m; i++, j++)
                mat[i][j] = store.get(i);
        }
        
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++)
        //         System.out.print(mat[i][j] + " ");
        //     System.out.println();
        // }
        
        for(int gap = 1; gap < n; gap++) {
            
            List<Integer> store = new ArrayList<>();
            for(int i = gap, j = 0; i < n && j < m; i++, j++)
                store.add(mat[i][j]);
            
            Collections.sort(store);
            
            for(int i = gap, j = 0; i < n && j < m; i++, j++)
                mat[i][j] = store.get(j);
        }
        
        return mat;
    }
}