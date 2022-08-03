class MyCalendar {

    HashMap<Integer, Integer> calender;
    public MyCalendar() {
        calender = new HashMap();
    }
    
    public boolean book(int start, int end) {
        for(Map.Entry<Integer, Integer> entry : calender.entrySet()) {
            if((entry.getKey() <= start && entry.getValue() > start) || (entry.getKey() < end && entry.getValue() > end) || (start < entry.getKey() && end > entry.getKey()) || (start < entry.getValue() && end > entry.getValue()) )
                return false;
        }
        
        calender.put(start, end);
        // System.out.println(calender);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */