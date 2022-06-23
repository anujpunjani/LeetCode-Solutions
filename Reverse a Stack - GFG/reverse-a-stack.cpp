// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution{
public:
    void helper(vector<int> &a, stack<int> &St, int n) {
        if(n == 0)
            return;
        
        helper(a, St, n-1);
        a.push_back(St.top());
        St.pop();
    }
    
    vector<int> Reverse(stack<int> St) {
        vector<int> ans;
        int n=St.size();
        helper(ans, St, n);
        return ans;
    }
};

// { Driver Code Starts.


int main(){
    int T;
    cin>>T;
    while(T--){
        int N;
        cin>>N;
        stack<int> St;
        for(int i=0;i<N;i++){
            int x;
            cin>>x;
            St.push(x);
        }
        Solution ob;
        vector<int> ans=ob.Reverse(St);
        for(int i=0;i<N;i++){
            cout<<ans[i];
            if(i!=N-1) cout<<" ";
        }
        cout<<endl;
    }
}  // } Driver Code Ends