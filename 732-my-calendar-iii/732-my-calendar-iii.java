class MyCalendarThree {

    Map<Integer, Integer> map;
    int maxCount;
    
    public MyCalendarThree() {
        map = new TreeMap();
        maxCount = 0;
    }
    
    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        int count = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            count += e.getValue();
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */