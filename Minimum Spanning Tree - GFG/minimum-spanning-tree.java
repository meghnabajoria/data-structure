//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    List<List<Pair>> adj = new ArrayList<>();
	    for(int i=0;i<V;i++)
	        adj.add(new ArrayList<>());
	        
	   for(int i=0;i<edges.length;i++){
	       for(int j=0;j<edges[0].length;j++){
	           adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
	           adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
	       }
	   }
	   
	   PriorityQueue<Pair> queue = new PriorityQueue<Pair>((x,y) -> x.distance - y.distance);
	   queue.add(new Pair(0,0));
	   int[] vis = new int[V];
	   int sum=0;
	   
	   while(!queue.isEmpty()){
	       int node = queue.peek().node;
	       int wt = queue.peek().distance;
	       queue.remove();
	       
	       if(vis[node] == 1) continue;
	       
	       vis[node] = 1;
	       sum = sum + wt;
	       
	       for(int i=0;i<adj.get(node).size();i++) {
	           Pair pair = adj.get(node).get(i);
	           int edW = pair.distance;
	           int adjNode = pair.node;
	           
	           if(vis[adjNode] == 0) {
	               queue.add(new Pair(adjNode, edW));
	           }
	       }
	   }
	   return sum;
	}
}

class Pair{
    int node;
    int distance;
    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}