class Solution {
public:
    
    bool is_possible(int speed, vector<int> &piles, int h) {
        
        long int hours = 0;
        for(auto pile : piles) {
            hours += pile/speed;
            if(pile%speed != 0) hours++;
        }
        
        return hours <= h;
    }
    
    int minEatingSpeed(vector<int>& piles, int h) {
        int low = 1;
        int high = *max_element(piles.begin(), piles.end());
        
        int ans = high;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(is_possible(mid, piles, h)) {
                ans = mid;
                high = mid - 1;
            } else 
                low = mid + 1;
            
        }
        
        return ans;
    }
};