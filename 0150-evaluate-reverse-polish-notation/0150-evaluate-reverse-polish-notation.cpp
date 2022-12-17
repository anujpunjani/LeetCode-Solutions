class Solution {
public:
    
    bool is_operator(string ch) {
        return ch == "+" || ch == "-" || ch == "*" || ch == "/";
    }
    
    int evalRPN(vector<string>& tokens) {
        stack<long> stk;
        
        for(string token : tokens) {
            if(is_operator(token)) {
                long num2 = stk.top();
                stk.pop();
                long num1 = stk.top();
                stk.pop();
                
                long temp = 0;
                
                if(token == "+")
                    temp = num1 + num2;
                else if(token == "-")
                    temp = num1 - num2;
                else if(token == "*")
                    temp = num1 * num2;
                else
                    temp = num1 / num2;
                
                stk.push(temp);
            } else {
                stk.push(stoi(token));
            }
        }
        
        return stk.top();
    }
};