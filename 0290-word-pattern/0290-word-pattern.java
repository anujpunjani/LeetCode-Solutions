class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] words = s.split(" ");
        
        if(words.length != pattern.length()) return false;
        
        HashMap<Character, String> m = new HashMap<>();
        

        
        for(int i = 0; i < pattern.length(); i++) {
            
            m.putIfAbsent(pattern.charAt(i), words[i]);

            String temp = m.get(pattern.charAt(i));
            
            
            if(!temp.equals(words[i]))
                return false;
            
        }
        
        HashMap<String, Character> m1 = new HashMap<>();
        

        
        for(int i = 0; i < pattern.length(); i++) {
            
            m1.putIfAbsent(words[i], pattern.charAt(i));

            Character temp = m1.get(words[i]);
            
            
            if(!temp.equals(pattern.charAt(i)))
                return false;
            
        }
        
        return true;
    }
}