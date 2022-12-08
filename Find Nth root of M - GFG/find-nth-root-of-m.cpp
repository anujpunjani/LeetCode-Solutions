//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	public:
	int NthRoot(int n, int m)
	{
	    
	    if(m == 1) return m;
	    
	    int low = 0, high = m/n;
	    
	    while(low <= high) {
	        int mid = low + (high - low)/2;
	        double pow_num = pow(mid, n);

	        if(pow_num == m) return mid;
	        else if(pow_num < m) low = mid + 1;
	        else high = mid - 1;
	    }
	    
	    return -1;
	}  
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		Solution ob;
		int ans = ob.NthRoot(n, m);
		cout << ans << "\n";
	}  
	return 0;
}
// } Driver Code Ends