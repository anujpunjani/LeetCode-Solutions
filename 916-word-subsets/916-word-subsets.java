class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int freq[] = new int[26];
        for(String word : words2) {
            int count[] = new int[26];
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                count[ch - 'a']++;
                freq[ch-'a'] = Math.max(freq[ch-'a'], count[ch-'a']);
            }
        }
        
        List<String> ans = new ArrayList<>();
        for(String word : words1) {
            int count[] = new int[26];
            for(int i = 0; i < word.length(); i++)
                count[word.charAt(i) - 'a']++;
            for(int i = 0; i <= 26; i++) {
                if(i == 26) {
                    ans.add(word); break;
                }
                if(count[i] < freq[i])
                    break;
            }
        }
        
        return ans;
    }
}