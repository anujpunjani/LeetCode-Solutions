class Solution {
    public int compress(char[] chars) {
        int count = 1;
        char last = chars[0];
        int index = 0;
        for(int i = 1; i < chars.length; i++) {
            
            if(last != chars[i]) {
                if(count != 1) {
                    
                    chars[index++] = last;

                    if(count > 9) {
                        String temp = "" + count;
                        for(int j = 0; j < temp.length(); j++)
                            chars[index++] = temp.charAt(j);
                    }else
                        chars[index++] = (char)(count + '0');
                } else {
                    chars[index++] = last;
                }
                
                last = chars[i];
                count = 1;
                
            } else {
                count++;
            }
            
        }
        
        if(count != 1) {
            chars[index++] = last;
            
            if(count > 9) {
                String temp = "" + count;
                for(int j = 0; j < temp.length(); j++)
                    chars[index++] = temp.charAt(j);
            }else
                chars[index++] = (char)(count + '0');
            
        } else {
            chars[index++] = last;
        }
        return index;
    }
}