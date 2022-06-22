// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends


class Solution
{
    public:
    //Function to return k largest elements from an array.
    vector<int> kLargest(int arr[], int n, int k)
    {
        priority_queue<int, vector<int>, greater<int>> pq;
        
        for(int i = 0; i < n; i++) {
            
            if(pq.size() == k) {
                
                if(pq.top() < arr[i]) {
                    pq.pop();
                    pq.push(arr[i]);
                }
                
            } else
                pq.push(arr[i]);
        }
        
        vector<int> ans(pq.size());
        while(pq.size() > 0) {
            ans[pq.size()-1] = pq.top();
            pq.pop();
        }
        
        return ans;
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin >> t;
    while(t--){
        int n, k;
        cin >> n >> k;
        
        int arr[n];
        for(int i = 0; i < n;i++)
            cin>>arr[i];
        Solution ob;
        vector<int> result = ob.kLargest(arr, n, k);
        for (int i = 0; i < result.size(); ++i)
            cout<<result[i]<<" ";
        cout << endl;
        
    }
    return 0;
}
  // } Driver Code Ends