class StockSpanner {

    Stack<int[]> stk;
    public StockSpanner() {
        stk = new Stack();
    }
    
    public int next(int price) {
        int span = 1;
        
        while(stk.size() > 0 && price >= stk.peek()[0])
            span += stk.pop()[1];
        
        stk.push(new int[]{price, span});
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */