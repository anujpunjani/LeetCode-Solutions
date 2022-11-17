class Solution {
    
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        
        int ax1 = rec1[0];
        int ay1 = rec1[1];
        int ax2 = rec1[2];
        int ay2 = rec1[3];
        
        int bx1 = rec2[0];
        int by1 = rec2[1];
        int bx2 = rec2[2];
        int by2 = rec2[3];
        
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int xOverlap = right - left;
        
        int top = Math.min(ay2, by2);
        int down = Math.max(ay1, by1);
        int yOverlap = top - down;
        
        int overlap = 0;
        
        if(yOverlap > 0 && xOverlap > 0)
            return true;
        return false;
    }
}