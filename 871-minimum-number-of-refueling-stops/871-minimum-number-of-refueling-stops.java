class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int ans = 0;
        int prev = 0;
        
        for(int[] station : stations) {
            int distance = station[0];
            int fuel = station[1];
            
            startFuel -= distance - prev;
            
            while(pq.size() > 0 && startFuel < 0) {
                startFuel += pq.remove();
                ans++;
            }
            
            if(startFuel < 0) return -1;
            prev = distance;
            pq.add(fuel);
        }
        
        startFuel -= target - prev;
        while(pq.size() > 0 && startFuel < 0) {
            startFuel += pq.remove();
            ans++;
        }

        if(startFuel < 0) return -1;
        
        return ans;
    }
}