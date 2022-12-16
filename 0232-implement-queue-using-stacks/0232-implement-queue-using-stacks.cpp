class MyQueue {
public:
    
    stack<int> main;
    stack<int> helper;
    
    MyQueue() {
        
    }
    
    void push(int x) {
        main.push(x);
    }
    
    int pop() {
        if(helper.size() != 0) {
            int temp = helper.top();
            helper.pop();
            return temp;
        }
        
        while(main.size() > 0) {
            helper.push(main.top());
            main.pop();
        }
        
        int temp = helper.top();
        helper.pop();
        return temp;
    }
    
    int peek() {
        if(helper.size() != 0) {
            int temp = helper.top();
            return temp;
        }
        
        while(main.size() > 0) {
            helper.push(main.top());
            main.pop();
        }
        
        int temp = helper.top();
        return temp;
    }
    
    bool empty() {
        return main.size() == 0 && helper.size() == 0;
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */