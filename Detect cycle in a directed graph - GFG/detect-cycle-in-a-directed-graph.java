//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis = new int[V];
        Arrays.fill(vis, 0);
        int[] pathVis = new int[V];
        Arrays.fill(pathVis, 0);
        
        for(int i=0;i<V;i++) {
            if(vis[i] != 1) {
                Boolean isCycle = dfs(i, adj, vis, pathVis);
                //Arrays.fill(pathVis, 0);
                if(isCycle)
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
        vis[node] = 1;
        pathVis[node] = 1;
        
        for(int i=0;i<adj.get(node).size();i++) {
            
            int node_ = adj.get(node).get(i);
            
            if(vis[node_] == 1 && pathVis[node_] == 1) {
                return true;
            }
            else if(vis[node_] == 0) {
                if(dfs(node_, adj, vis, pathVis))
                    return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
}