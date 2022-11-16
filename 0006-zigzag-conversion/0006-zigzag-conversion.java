class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1) return s;
        
        List<StringBuilder> rows = new ArrayList();
        for(int i = 0; i < Math.min(s.length(), numRows); i++)
            rows.add(new StringBuilder(""));
        
        int currRow = 0;
        boolean goingDown = false;
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            rows.get(currRow).append(ch);
            
            if(currRow == 0 || currRow == numRows - 1)
                goingDown = !goingDown;
            
            currRow += goingDown? 1 : -1;
        }
        
        StringBuilder ans = new StringBuilder("");
        for(StringBuilder sb : rows)
            ans.append(sb);
            
        return ans.toString();
    }
}