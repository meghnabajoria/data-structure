//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> list, int V) {
        // code here
        
        // change matrix to adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<V;i++) {
            for(int j=0;j<V;j++) {
                if( i!= j && list.get(i).get(j) == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        // make vis array
        int[] vis = new int[V+1];
        Arrays.fill(vis, 0);
        int count = 0;
        
        for(int i=0;i<V;i++) {
            if(vis[i] == 0) {
                count++;
                dfs(i, vis, adj);
            }
        }
        return count;
    }
    
    private static void dfs(int node, int[] vis, List<List<Integer>> adj) {
        vis[node] = 1;
        for(int i=0;i<adj.get(node).size();i++) {
            if(vis[adj.get(node).get(i)] != 1) {
                dfs(adj.get(node).get(i), vis, adj);
            }
        }
    }
};