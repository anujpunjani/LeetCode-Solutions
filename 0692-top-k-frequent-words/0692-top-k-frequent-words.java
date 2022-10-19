class Solution {
    
    class Pair implements Comparable<Pair> {
        
        String word;
        int count;
        
        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
        
        public int compareTo(Pair x) {
            
            if(count == x.count)
                return x.word.compareTo(word);
            
            return count - x.count;
        }
        
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        
        List<String> ans = new ArrayList<>();
        
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        for(String word : map.keySet()) {
            if(heap.size() == k) {
                if(heap.peek().count < map.get(word) || (heap.peek().count == map.get(word) && (word.compareTo(heap.peek().word)) < 0)) {
                    heap.remove();
                    heap.add(new Pair(word, map.get(word)));
                }
            }
            else
                heap.add(new Pair(word, map.get(word)));
        }

        
        while(k --> 0) {
            Pair x = heap.remove();
            ans.add(x.word);
        }
        Collections.reverse(ans);
        
        return ans;
    }
}