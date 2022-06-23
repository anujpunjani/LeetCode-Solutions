// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int phy[] = new int[n];
    		int chem[] = new int[n];
    		int math[] = new int[n];
            
            for (int i = 0; i < n; ++i)
                {
                    phy[i]=sc.nextInt();
                    chem[i]=sc.nextInt();
                    math[i]=sc.nextInt();
                }
		    
		    Solution ob = new Solution();
		    
		    ob.customSort (phy, chem, math, n);
    		for (int i = 0; i < n; ++i)
    			System.out.println(phy[i]+" " + chem[i] + " " + math[i]);

        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static class Marks {
        int phy;
        int chem;
        int math;
        
        Marks(int phy, int chem, int math) {
            this.phy = phy;
            this.chem = chem;
            this.math = math;
        }
    }
    
    static class MarksCompare implements Comparator<Marks> {
        
        @Override
        public int compare(Marks s1, Marks s2) {
            
            if(s1.phy < s2.phy) {
                return -1;
            } else if(s1.phy > s2.phy)
                return 1;
            else {
                if(s1.chem > s2.chem)
                    return -1;
                else if(s1.chem < s2.chem)
                    return 1;
                else {
                    if(s1.math < s2.math)
                        return -1;
                    else if(s1.math > s2.math)
                        return 1;
                    else
                        return 0;
                }
            }
            
        }
    }
    
    public void customSort (int phy[], int chem[], int math[], int N)
    {
        PriorityQueue<Marks> pq = new PriorityQueue<>(new MarksCompare());
        
        ArrayList<Marks> marks = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            marks.add(new Marks(phy[i], chem[i], math[i]));
        }
        
        pq.addAll(marks);
        
        for(int i = 0; i < N; i++) {
            Marks temp = pq.remove();
            phy[i] = temp.phy;
            chem[i] = temp.chem;
            math[i] = temp.math;
        }
    }
}
