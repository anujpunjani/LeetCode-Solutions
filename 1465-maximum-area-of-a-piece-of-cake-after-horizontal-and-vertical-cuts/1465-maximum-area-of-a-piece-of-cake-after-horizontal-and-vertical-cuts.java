class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long mod = 1000000007;
        
        long maxh = horizontalCuts[0];
        long maxw = verticalCuts[0];
        
        for(int i = 1; i < horizontalCuts.length; i++)
            maxh = Math.max(maxh, horizontalCuts[i]-horizontalCuts[i-1]);
        
        maxh = Math.max(h - horizontalCuts[horizontalCuts.length - 1], maxh);
        
        for(int i = 1; i < verticalCuts.length; i++)
            maxw = Math.max(maxw, verticalCuts[i]-verticalCuts[i-1]);
        
        maxw = Math.max(w - verticalCuts[verticalCuts.length - 1], maxw);
        
        return (int)((maxh*maxw)%mod);
    }
}