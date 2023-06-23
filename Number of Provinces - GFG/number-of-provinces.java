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
        
        //create adj list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList());
        
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(i != j && list.get(i).get(j) == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
                    
            }
        }
        
        // bfs
        int count = 0;
        boolean vis[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0;i<V;i++) {
            if(!vis[i]) {
                count++;
                //System.out.println("count = " + count);
                queue.add(i);
                vis[i] = true;
                bfs(i, vis, adj, queue);
            }
        }
        return count;
    }
    
    private static void bfs(int node, boolean[] vis, 
        List<List<Integer>> adj, Queue<Integer> queue) {
            
            while(!queue.isEmpty()) {
                int nodee = queue.poll();
                //System.out.println("popped nodee = " + nodee);
                vis[nodee] = true;
                for(Integer it : adj.get(nodee)) {
                    //System.out.println("it = " + it);
                    if(!vis[it]) {
                        vis[it] = true;
                        queue.add(it);
                    }
                }
            }
        
    }
};