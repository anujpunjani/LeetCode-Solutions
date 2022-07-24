class Solution {
    
    class Pair {
        char data;
        int state;
        Pair(char data, int state) {
            this.data = data;
            this.state = state;
        }
    }
    
    public boolean isValidSerialization(String preorder) {
        
        if(preorder.charAt(0) == '#' && preorder.length() == 1) return true;
        if(preorder.charAt(0) == '#') return false;
        Stack<Pair> stk = new Stack<>();
        int ptr = 0;
        stk.push(new Pair(preorder.charAt(ptr), -1));
        while(ptr < preorder.length() && preorder.charAt(ptr) != ',')
            ptr++;
        ptr++;
        while(ptr < preorder.length()) {
            
            if(stk.size() == 0) return false;
            Pair top = stk.peek();
            if(ptr < preorder.length())
            // System.out.println("data-> " + top.data +" " +ptr +" char-> " + preorder.charAt(ptr) + " state-> " + top.state);
            
            if(top.state == -1) {
                top.state++;
                if(ptr > preorder.length())
                    return false;
                char ch = preorder.charAt(ptr);
                if(ch != '#')
                    stk.push(new Pair(ch, -1));
                while(ptr < preorder.length() && preorder.charAt(ptr) != ',')
                    ptr++;
                ptr++;
            } else if(top.state == 0) {
                top.state++;
                
                if(ptr > preorder.length()) 
                    return false;
                char ch = preorder.charAt(ptr);
                if(ch != '#')
                    stk.push(new Pair(ch, -1));
                while(ptr < preorder.length() && preorder.charAt(ptr) != ',')
                    ptr++;
                ptr++;
            } else {
                stk.pop();
            }
            
        }
        while(stk.size() > 0 && stk.peek().state == 1) 
            stk.pop();
        
        // System.out.println(stk);
        return stk.isEmpty();
    }
}