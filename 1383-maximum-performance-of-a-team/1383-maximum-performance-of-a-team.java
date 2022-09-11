class Solution {
    
    class Pair {
        int speed;
        int efficiency;
        
        Pair(int s, int e) {
            speed = s;
            efficiency = e;
        }
        
        public String toString(){
            return "{" + efficiency + ", " + speed + "}";
        }
    }
    
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        ArrayList<Pair> engineers = new ArrayList();
        
        for(int i = 0; i < n; i++)
            engineers.add(new Pair(speed[i], efficiency[i]));
        
        engineers.sort((a, b) -> b.efficiency - a.efficiency);
        
        PriorityQueue<Integer> currentTeam = new PriorityQueue();
        
        long teamSpeed = 0;
        long maxPerformance = 0;
        
        for(Pair engineer : engineers) {
            
            if(currentTeam.size() == k) {
                int slowSpeed = currentTeam.remove();
                teamSpeed -= slowSpeed;
            }
            
            currentTeam.add(engineer.speed);
            teamSpeed += engineer.speed;
            
            long performance = teamSpeed * engineer.efficiency;
            maxPerformance = Math.max(maxPerformance, performance);
        }
        
        return (int)(maxPerformance % 1000000007);
    }
}