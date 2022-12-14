//{ Driver Code Starts
// Initial template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template in C++

class Solution 
{
    public:
    //Function to find minimum number of pages.
    
    bool isPossible(int maxLoad, int pages[],int books,int students)
    {
        //Your code here
        int currStud = 1, currPages = 0;
        for(int i = 0; i < books && currStud <= students; i++)
        {
            if((currPages + pages[i]) <= maxLoad)
            {
                currPages += pages[i];
            }else{
                currStud += 1;
                currPages = pages[i];
            }
        }
        
        if(currStud <= students) return true;
        return false;
    }
    
    int findPages(int A[], int N, int M) 
    {
        if(M > N) return -1;
        
        int low = 0, high = 0;
        for(int i = 0; i < N; i++)
        {
            if(low < A[i])
                low = A[i];
                
            high += A[i];
        }
        
        int ans = -1;
        
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(isPossible(mid, A,N, M) == true)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int A[n];
        for(int i=0;i<n;i++){
            cin>>A[i];
        }
        int m;
        cin>>m;
        Solution ob;
        cout << ob.findPages(A, n, m) << endl;
    }
    return 0;
}

// } Driver Code Ends