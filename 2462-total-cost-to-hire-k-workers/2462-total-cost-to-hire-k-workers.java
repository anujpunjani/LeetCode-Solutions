class Solution {
    
    class Pair implements Comparable<Pair>{
        int index;
        int num;
        char side;
        
        Pair(int n, int i, char s) {
            num = n;
            index = i;
            side = s;
        }
        
        public int compareTo(Pair other) {
            if(other.num == num) return index - other.index;
            return num - other.num;
        }
    }
    
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        int left = 0, right = costs.length - 1;
        
        for(int i = 0; i < candidates; i++) {
            pq.add(new Pair(costs[left], left, 'L'));
            left++;
        }
                   
        for(int i = 0; i < candidates && left <= right; i++) {
            pq.add(new Pair(costs[right], right, 'R'));
            right--;
        }
        
        long ans = 0;
        
        while(k --> 0 && !pq.isEmpty()) {
            Pair top = pq.remove();
            ans += top.num;
            
            if(left <= right) {
                if(top.side == 'L') {
                    pq.add(new Pair(costs[left], left, 'L'));
                    left++;
                } else {
                    pq.add(new Pair(costs[right], right, 'R'));
                    right--;
                }
            }
        }
        
        return ans;
    }
}