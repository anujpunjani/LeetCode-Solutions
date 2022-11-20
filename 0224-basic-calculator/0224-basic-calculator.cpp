class Solution {
public:
    
    int performOp(int a, char op, int b) {
        if(op == '+') return a + b;
        if(op == '-') return a - b;
        if(op == '*') return a * b;
        if(op == '/') return a / b;
        return 0;
    }
    
    int precedence(char op) {
        if(op == '*' || op == '/') return 2;
        if(op == '+' || op == '-') return 1;
        return 0;
    }
    
    string refine(string exp) {
        string refined = "";
        
        for(int i = 0; i < exp.size(); i++) {
            char c = exp[i];
            
            if(c == ' ') continue;
            if(c == '+') {
                if(refined.size() == 0 || refined.back() == '(' )
                    refined += "0+";
                else if(refined.back() == '+' || refined.back() == '-')
                    continue;
                else
                    refined += c;
            } else if(c == '-') {
                if(refined.size() == 0 || refined.back() == '(' )
                    refined += "0-";
                else if(refined.back() == '+')
                    refined[refined.size() - 1] = '-';
                else if(refined.back() == '-')
                    refined[refined.size() - 1] = '+';
                else
                    refined += c;
            } else
                    refined += c;
    
        }
        
        return refined;
    }
    
    int calculate(string s) {
        s = refine(s);

        stack<int> operand;
        stack<char> operater;
        
        for(int i = 0; i < s.size(); i++) {
            char c = s[i];
            
            if(c == ' ') continue;
            if(c >= '0' and c <= '9') {
                int num = 0;
                while(i < s.size() and s[i] >= '0' and s[i] <= '9') {
                    num = num * 10 + (s[i] - '0');
                    i++;
                }
                i--;
                operand.push(num);
            } else if(c == '(') operater.push(c);
            else if(c == ')') {
                while(operater.top() != '(') {
                    int b = operand.top(); operand.pop();
                    int a = operand.top(); operand.pop();
                    char op = operater.top(); operater.pop();
                    operand.push(performOp(a, op, b));
                }
                operater.pop();
            } else {
                while(operater.size() > 0 && operater.top() != '(' && precedence(c) <= precedence(operater.top())) {
                    int b = operand.top(); operand.pop();
                    int a = operand.top(); operand.pop();
                    char op = operater.top(); operater.pop();
                    operand.push(performOp(a, op, b));
                }
                operater.push(c);
            }
            
        }
        
        while(operater.size() > 0) {
            int b = operand.top(); operand.pop();
            int a = operand.top(); operand.pop();
            char op = operater.top(); operater.pop();
            operand.push(performOp(a, op, b));
        }
        
        return operand.top();
    }
};