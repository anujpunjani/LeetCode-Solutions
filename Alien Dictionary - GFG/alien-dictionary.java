// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    StringBuilder topo = new StringBuilder("");
    
    void dfs(char src, HashMap<Character, ArrayList<Character>> graph, HashMap<Character, Boolean> vis) {
        
        if(vis.getOrDefault(src, false) == true)
            return;
        
        vis.put(src, true);
        
        for(char nbr : graph.get(src)) {
            dfs(nbr, graph, vis);
        }
        
        topo.append(src);
    }
    
    public String findOrder(String [] dict, int N, int K)
    {
        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();

        for(int i = 0; i < N-1; i++) {
            
            String a = dict[i];
            String b = dict[i+1];
            int j = 0;
            while(j < a.length() && j < b.length()) {
                
                if(a.charAt(j) != b.charAt(j)) {
                    if(graph.containsKey(a.charAt(j)) == false)
                        graph.put(a.charAt(j), new ArrayList<>());
                    
                    if(graph.containsKey(b.charAt(j)) == false)
                        graph.put(b.charAt(j), new ArrayList<>());
                        
                    graph.get(a.charAt(j)).add(b.charAt(j));
                    break;
                }
                j++;
            }
        }
        // System.out.println(graph);
        HashMap<Character, Boolean> vis = new HashMap<>();
        for(char key : graph.keySet())
            dfs(key, graph, vis);
        
        return topo.reverse().toString();
    }
}