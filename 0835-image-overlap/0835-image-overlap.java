class Solution {
    
    private int countOverlap(int[][] img1, int[][] img2, int r, int c) {
        int n = img1.length;
        int overlap = 0;
        
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < n; j++) {
                int nr = i - r;
                int nc = j - c;
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                
                if(img1[nr][nc] == 1 && img2[i][j] == 1)
                    overlap++;
            }
        
        return overlap;
    }
    
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxCount = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                maxCount = Math.max(maxCount, countOverlap(img1, img2, i, j));
                maxCount = Math.max(maxCount, countOverlap(img1, img2, i, -j));
                maxCount = Math.max(maxCount, countOverlap(img1, img2, -i, j));
                maxCount = Math.max(maxCount, countOverlap(img1, img2, -i, -j));
            }
        }
        
        return maxCount;
    }
}