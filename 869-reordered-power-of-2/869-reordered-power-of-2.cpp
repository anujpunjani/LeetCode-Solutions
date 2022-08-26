class Solution {
public:
    bool reorderedPowerOf2(int n) {
        if(n == 0) return false;
        
        string str = "";
        while(n != 0) {
            str += to_string(n%10);
            n /= 10;
        }
        
        sort(str.begin(), str.end());
        
        int temp = 1;
        int power = pow(10, 9);
        
        while(temp <= power) {
            string t = to_string(temp);
            sort(t.begin(), t.end());
            if(str == t) return true;
            temp *= 2;
        }
        
        return false;
    }
};