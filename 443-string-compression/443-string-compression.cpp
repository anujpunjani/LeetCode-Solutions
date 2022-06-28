class Solution {
public:
    int compress(vector<char>& chars) {
        
        int count = 1;
        char last = chars[0];
        int index = 0;
        for(int i = 1; i < chars.size(); i++) {
            
            if(last != chars[i]) {
                if(count != 1) {
                    
                    chars[index++] = last;

                    if(count > 9) {
                        string temp = to_string(count);
                        for(char ch : temp)
                            chars[index++] = ch;
                    }else
                        chars[index++] = (count + '0');
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
                string temp = to_string(count);
                for(char ch : temp)
                    chars[index++] = ch;
            }else
                chars[index++] = (count + '0');
            
        } else {
            chars[index++] = last;
        }
        return index;
    }
};