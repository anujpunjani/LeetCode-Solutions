class Solution {
public:
    int minStoneSum(vector<int>& piles, int k) {
        priority_queue<int> max_heap;
        for(int pile : piles)
            max_heap.push(pile);
        
        while(k --> 0) {
            int top = max_heap.top();
            max_heap.pop();
            
            int temp = top/2;
            if(top%2 != 0) temp++;
            max_heap.push(temp);
        }
        
        int sum = 0;
        while (!max_heap.empty()) {
            sum += max_heap.top();
            max_heap.pop();
        }
        
        return sum;
    }
};