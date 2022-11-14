// link : https://practice.geeksforgeeks.org/problems/cheapest-flights-within-k-stops/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=cheapest-flights-within-k-stops
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        
        // make adj list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
           adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<flights.length;i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        //
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        Queue<Node> queue = new LinkedList<>();
        // stops, node, dist
        queue.add(new Node(0, src, 0));
        
        // bfs
        while(!queue.isEmpty()) {
             Node it = queue.peek();
             queue.remove();
             int stops = it.first;
             int node = it.second;
             int cost = it.third;
             
             if(stops > k)
                continue;
            for(Pair itr : adj.get(node)) {
                int adjNode = itr.first;
                int edW = itr.second;
                if(cost + edW < dis[adjNode] && stops <= k) {
                    dis[adjNode] = cost + edW;
                    queue.add(new Node(stops+1, adjNode, cost+edW));
                }
            }
        }
    
        if(dis[dst] == Integer.MAX_VALUE)
            return -1;
        
        return dis[dst];
    }

}

class Pair {
    int first;
    int second;
    
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Node {
    //int start;
    int first;
    int second;
    int third;
    
    public Node(int first, int second, int third) {
        //this.start = start;
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
