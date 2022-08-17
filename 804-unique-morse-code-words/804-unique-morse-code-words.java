class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String morse[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> ans = new HashSet();
        for(String word : words) {
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < word.length(); i++)
                sb.append(morse[word.charAt(i) - 'a']);
            ans.add(sb.toString());
        }
        
        return ans.size();
    }
}