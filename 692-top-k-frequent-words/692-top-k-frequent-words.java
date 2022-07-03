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
                return word.compareTo(x.word);
            
            return x.count - count;
        }
        
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Pair> minheap = new PriorityQueue<>(Collections.reverseOrder());
        
        List<String> ans = new ArrayList<>();
        
        for(String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        for(String word : map.keySet()) {
            minheap.add(new Pair(word, map.get(word)));
            if(minheap.size() > k) minheap.remove();
        }

        
        while(k --> 0) {
            Pair x = minheap.remove();
            ans.add(x.word);
        }
            
        Collections.reverse(ans);
        
        return ans;
    }
}