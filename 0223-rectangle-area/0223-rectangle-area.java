class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int areaA = (ay2 - ay1) * (ax2 - ax1);        
        int areaB = (by2 - by1) * (bx2 - bx1);        
        
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int xOverlap = right - left;
        
        int top = Math.min(ay2, by2);
        int down = Math.max(ay1, by1);
        int yOverlap = top - down;
        
        int overlap = 0;
        
        if(yOverlap > 0 && xOverlap > 0)
            overlap = yOverlap * xOverlap;
        
        return areaA + areaB - overlap;
    }
}