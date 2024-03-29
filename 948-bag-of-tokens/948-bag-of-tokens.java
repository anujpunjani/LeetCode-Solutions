class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        
        int i = 0, j = tokens.length - 1;
        int score = 0;
        
        while(i < j) {
            
            if(power < tokens[i] && score == 0) return score;
            
            if(power < tokens[i] && score > 0) {
                power += tokens[j];
                score--;
                j--;
            } else {
                power -= tokens[i];
                score++;
                i++;
            }

        }
        
        if(i == j && power >= tokens[i]) score++;
        
        return score;
    }
}