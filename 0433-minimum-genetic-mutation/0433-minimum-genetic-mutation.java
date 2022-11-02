class Solution {
    
    private boolean diff(String a, String b) {
        if(a.length() != b.length()) return false;
        
        int count = 0;
        for(int i = 0; i < b.length(); i++)
            if(a.charAt(i) != b.charAt(i)) count++;
    
        return count == 1;
    }
    
    public int minMutation(String start, String end, String[] bank) {
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(int i = 0; i < bank.length; i++) {
            for(int j = i + 1; j < bank.length; j++)
                if(diff(bank[i], bank[j])) {
                    if(!map.containsKey(bank[i]))
                        map.put(bank[i], new ArrayList());
                    
                    if(!map.containsKey(bank[j]))
                        map.put(bank[j], new ArrayList());
                    
                    map.get(bank[i]).add(bank[j]);
                    map.get(bank[j]).add(bank[i]);
                }
            
        }
        
        for(int i = 0; i < bank.length; i++)
            if(diff(bank[i], start)) {
                if(!map.containsKey(bank[i]))
                    map.put(bank[i], new ArrayList());

                if(!map.containsKey(start))
                    map.put(start, new ArrayList());

                map.get(bank[i]).add(start);
                map.get(start).add(bank[i]);
            }
        
        HashSet<String> set = new HashSet();
        set.add(start);
        Queue<String> q = new LinkedList();
        q.add(start);
        int ans = 0;
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            while(size --> 0) {
                
                String gene = q.remove();
                
                for(String mutation : map.getOrDefault(gene, new ArrayList<String>())) 
                    if(!set.contains(mutation)) {
                        set.add(mutation);
                        q.add(mutation);
                    }
            }
            
            ans++;
            if(set.contains(end)) return ans;
        }
            
        return -1;
    }
}