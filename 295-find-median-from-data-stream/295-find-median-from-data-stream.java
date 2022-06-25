class MedianFinder {
    
    PriorityQueue<Integer> left, right;
    
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        
        if(left.size() == 0 && right.size() == 0) {
            left.add(num);
            return;
        }
        
        int median = (int)findMedian();
        if(median < num)
            right.add(num);
        else
            left.add(num);
        
        if(right.size() > left.size() + 1)
            left.add(right.remove());
        else if(right.size() + 1 < left.size())
            right.add(left.remove());
        
    }
    
    public double findMedian() {
        if(left.size() == right.size() + 1)
            return left.peek();
        else if(left.size() + 1 == right.size())
            return right.peek();
        else
            return (left.peek() + right.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */