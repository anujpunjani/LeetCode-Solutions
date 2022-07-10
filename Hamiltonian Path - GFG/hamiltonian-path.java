// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    
    boolean dfs(int src, boolean[] vis, ArrayList<ArrayList<Integer>> graph, int visCount) {
        
        vis[src] = true;
        visCount++;
        
        if(visCount == graph.size())
            return true;
        
        for(int nbr : graph.get(src)) {
            if(vis[nbr] == false) {
                if(dfs(nbr, vis, graph, visCount))
                    return true;
            }    
        }
        
        vis[src] = false;
        return false;
    }
    
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        int n = N+1;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < N+1; i++)
            graph.add(new ArrayList<>());
            
        for(ArrayList list : Edges) {
            // System.out.println(list);
            graph.get((int)list.get(0)).add((int)list.get(1));
            graph.get((int)list.get(1)).add((int)list.get(0));
        }
        // System.out.println(graph);
        for(int i = 1; i < N+1; i++)
            if(dfs(i, new boolean[n], graph, 1))
                return true;
        return false;
    }
} 