class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // the maximum number of pigs required will always be <= 10 (consider poorPigs(1000,1,1) to prove this)
        
        // return (int)Math.ceil(Math.log(buckets) / Math.log(totalTime / poisonTime + 1));
        
        int maxPigs = 10;
        
        int base = minutesToTest/minutesToDie + 1;
        for(int i = 0; i < maxPigs; i++) {
            if(Math.pow(base, i) >= buckets)
                return i;
        }
        
        return maxPigs;
    }
}