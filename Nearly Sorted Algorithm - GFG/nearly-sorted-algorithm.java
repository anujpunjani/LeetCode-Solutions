/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		
		while(t --> 0) {
		    
		    int n = scn.nextInt();
		    int k = scn.nextInt();
		    
		    int arr[] = new int[n];
		    
		    PriorityQueue<Integer> pq = new PriorityQueue<>();
		    
		    for(int i = 0; i < n; i++) {
		        arr[i] = scn.nextInt();
		        
		        if(i >= k) {
		            System.out.print(pq.remove() + " ");
		            pq.add(arr[i]);
		        } else {
		            pq.add(arr[i]);
		        }
		        
		    }
		    
		    while(pq.size() > 0)
		        System.out.print(pq.remove() + " ");
		       
		    System.out.println();
		}
		
	}
}