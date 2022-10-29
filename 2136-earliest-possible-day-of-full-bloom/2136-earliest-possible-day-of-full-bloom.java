class Solution {
    
    class Pair implements Comparable<Pair>{
        int plantTime;
        int growTime;
        
        Pair(int p, int g) {
            plantTime = p;
            growTime = g;
        }
        
        public int compareTo(Pair other) {
            if(growTime == other.growTime)
                return other.plantTime - plantTime;
            return other.growTime - growTime;
        }
    }
    
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        PriorityQueue<Pair> pq = new PriorityQueue();

        for(int i = 0; i < plantTime.length; i++) 
            pq.add(new Pair(plantTime[i], growTime[i]));
 
        int days = 0;
        int maxPlantTime = 0;
        while(!pq.isEmpty()) {
            Pair top = pq.remove();
            maxPlantTime += top.plantTime;
            days = Math.max(days, maxPlantTime + top.growTime);
        }
        
        return days;
    }
}