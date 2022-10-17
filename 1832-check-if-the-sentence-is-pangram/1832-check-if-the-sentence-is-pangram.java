class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] alphas = new boolean[26];
        int count = 0;
        for(int i = 0; i < sentence.length(); i++) {
            int c = sentence.charAt(i) - 'a';
            if(!alphas[c]) {
                alphas[c] = true;
                count++;
            }
            
            if(count == 26) return true;
        }
        
        return false;
    }
}