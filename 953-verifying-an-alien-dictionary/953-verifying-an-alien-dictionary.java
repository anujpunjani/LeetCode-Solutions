class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> ord = new HashMap();
        
        for(int i = 0; i < order.length(); i++)
            ord.put(order.charAt(i), i);
        for(int i = 0; i < words.length - 1; i++) {
            
            String a = words[i];
            String b = words[i+1];
            
            int j = 0;
            while(j < a.length() && j < b.length()) {
                
                if(a.charAt(j) != b.charAt(j)) {
                    if(ord.get(a.charAt(j)) > ord.get(b.charAt(j)))
                        return false;
                    else
                        break;
                }
                
                j++;
            }
            if(j == Math.min(a.length(), b.length()) && a.length() > b.length())
                return false;
        }
        
        return true;
    }
}