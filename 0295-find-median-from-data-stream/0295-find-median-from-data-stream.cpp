class MedianFinder {
public:
    
    priority_queue<int> left_maxheap;
    priority_queue<int, vector<int>, greater<int>> right_minheap;
    
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        double median = findMedian();
        if(num <= median) 
            left_maxheap.push(num);
        else
            right_minheap.push(num);
    
        if(left_maxheap.size() > right_minheap.size() + 1) {
            right_minheap.push(left_maxheap.top());
            left_maxheap.pop();
        } else if(left_maxheap.size() + 1 < right_minheap.size()) {
            left_maxheap.push(right_minheap.top());
            right_minheap.pop();
        }
    }
    
    double findMedian() {
        if(left_maxheap.size() == 0 && right_minheap.size() == 0) return -1;
        
        if(left_maxheap.size() == right_minheap.size())
            return (right_minheap.top() + left_maxheap.top()) / 2.0;
        else if(left_maxheap.size() > right_minheap.size())
            return left_maxheap.top();
        else
            return right_minheap.top();
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */