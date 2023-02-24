class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // adj list
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<flights.length;i++){
            for(int j=0;j<flights[i].length;j++){
                adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
            }
        }
        
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0, src, 0));
        
        int[] dis = new int[n];
        Arrays.fill(dis, (int)(1e9));
        dis[src] = 0;
        
        while(!queue.isEmpty()) {
            Tuple tuple = queue.peek();
            int stops = tuple.stops;
            int node = tuple.node;
            int cost = tuple.cost;
            queue.remove();
            
            if(stops > k)
                continue;
            
            for(int i=0;i<adj.get(node).size();i++){
                Pair pair = adj.get(node).get(i);
                int adjNode = pair.first;
                int edW = pair.second;
                int newCost = edW+cost;
                
                if(newCost < dis[adjNode] && stops<=k) {
                    dis[adjNode] = newCost;
                    queue.add(new Tuple(stops+1, adjNode, newCost));
                }
            }
        }
        if(dis[dst] == (int)(1e9)) return -1;
        return dis[dst];
        
    }
}
class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Tuple {
    int stops;
    int node;
    int cost;
    Tuple(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}