// graph dfs traversal

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> dsfList = new ArrayList<>();
        boolean[] visited = new boolean[V+1];
        
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                dfs(i, adj, dsfList, visited);
            }
        }
        return dsfList;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, 
    ArrayList<Integer> dfsList, boolean[] visited) {
       
       dfsList.add(node);
       visited[node] = true;
       ArrayList<Integer> nodes = adj.get(node);
       for(Integer nodule : nodes) {
           if(visited[nodule] == false) {
               dfs(nodule, adj, dfsList, visited);
           }
       }
    }
}
