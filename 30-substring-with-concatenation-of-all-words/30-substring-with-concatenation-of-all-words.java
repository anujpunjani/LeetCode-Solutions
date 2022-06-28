class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> ans = new ArrayList<>();
        
        HashMap<String, Integer> wmap = new HashMap<>();
        
        for(String word : words)
             wmap.put(word, wmap.getOrDefault(word, 0) + 1);
        
        int wordlen = words[0].length();
        int wordslen = wordlen*words.length;
        
        for(int i = 0; i <= s.length() - wordslen; i++) {
            
            int j = i + wordslen;
            
            HashMap<String, Integer> map = new HashMap<>();

            for(int k = i; k < j; k += wordlen) {
                String word = s.substring(k, k + wordlen);
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            
            boolean flag = true;
            
            for(String word : words) {
             
                int t1 = map.getOrDefault(word, 0);
                int t2 = wmap.get(word);
                
                if(t1 != t2) {
                    flag = false; break;
                }
            }
            if(flag)
                ans.add(i);
            
        }
        
        return ans;
    }
}