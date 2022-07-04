class Solution {
    public int candy(int[] ratings) {
        
        int ans = 0;
        int[] l2r = new int[ratings.length];
        int[] r2l = new int[ratings.length];
        
        Arrays.fill(l2r, 1);
        Arrays.fill(r2l, 1);
        
        for(int i = 1, j = ratings.length - 2; i < ratings.length; i++, j--) {
            
            if(ratings[i] > ratings[i-1])
                l2r[i] = l2r[i-1]+1;
            
            if(ratings[j] > ratings[j+1])
                r2l[j] = r2l[j+1]+1;
        }
        
        for(int i = 0; i < ratings.length; i++)
            ans += Math.max(l2r[i], r2l[i]);
        
        return ans;
    }
}