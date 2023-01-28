class SummaryRanges {
public:
    
    set<int> nums;
    
    SummaryRanges() {
        
    }
    
    void addNum(int value) {
        nums.insert(value);
    }
    
    vector<vector<int>> getIntervals() {
        vector<vector<int>> disjoint_interval;
        
        for(int n : nums) {
            int size = disjoint_interval.size();
            
            if(size > 0 && disjoint_interval.back().back() + 1 == n) 
                disjoint_interval.back().back() = n;
            else
                disjoint_interval.push_back({n, n});
        }
        
        return disjoint_interval;
    }
};

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges* obj = new SummaryRanges();
 * obj->addNum(value);
 * vector<vector<int>> param_2 = obj->getIntervals();
 */