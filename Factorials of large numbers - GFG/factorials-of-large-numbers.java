// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N){
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(1);
        
        while(N > 0) {
            
            int size = ans.size();
            int i = 0;
            int d = 0;
            int carry = 0;
            while(i < size) {
                
                d = N * ans.get(i) + carry;
                carry = d/10;
                ans.set(i, d%10);
                i++;
            }
            while(carry > 0) {
                ans.add(carry%10);
                carry/=10;
            }
            //System.out.println(ans);
            N--;
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}