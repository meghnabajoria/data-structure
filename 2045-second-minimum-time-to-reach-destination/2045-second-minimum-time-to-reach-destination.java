class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        // for(int i = 0; i < n; i++){
        //     adj.get(edges[i][0]).add(edges[i][1]);
        //     adj.get(edges[i][1]).add(edges[i][0]);
        // }
        
        int[][] dist = new int[n+1][2];
        for(int i=0;i<=n;i++){
            Arrays.fill(dist[i], (int)(1e9));
        }
        dist[1][0] = 0;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 0));
        
        int wait, time_new;
        
        while(!queue.isEmpty()) {
            int vert = queue.peek().node;
            int timee = queue.peek().time;
            queue.remove();
            
            wait = 0;
            if ((timee / change)%2 == 1) {
                wait = change - (timee % change);
            }
            
            time_new = timee + wait + time;
            
            for(int i=0;i<adj.get(vert).size();i++){
                int new_node = adj.get(vert).get(i);
                if(dist[new_node][0] > time_new) {
                    dist[new_node][0] = time_new;
                    queue.add(new Pair(new_node, time_new));
                }
                else if(dist[new_node][0] < time_new && dist[new_node][1] == (int)(1e9)) {
                    if(new_node == n)
                        return time_new;
                    dist[new_node][1] = time_new;
                    queue.add(new Pair(new_node, time_new));
                }
            }
        }
        return -1;
    }
}

class Pair {
    int node;
    int time;
    Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}