class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // create adj list
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        
        // create dis array
        int[] dis = new int[n+1];
        Arrays.fill(dis, (int)(1e9));
        dis[0] = 0;
        dis[k] = 0;
        
        // crate queue
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(k,0));
        
        // start bfs
        while(!queue.isEmpty()) {
            Pair pr = queue.peek();
            queue.remove();
            int nodee = pr.node;
            int timee = pr.time;
            //System.out.println("nodee:" +  nodee);
            for(int i=0;i<adj.get(nodee).size();i++){
                int adjNode = adj.get(nodee).get(i).node;
                //System.out.println("adjNode:" +  adjNode);
                
                int duration = adj.get(nodee).get(i).time;
                //System.out.println("duration:" +  duration);
                int total_time = timee + duration;
                
                if(total_time < dis[adjNode]) {
                    dis[adjNode] = total_time;
                    queue.add(new Pair(adjNode, total_time));
                }
            }
        }
        
        //System.out.println("dis : " + Arrays.toString(dis));
        int max = -1;
        for(int i=0;i<=n;i++){
            max = Math.max(max, dis[i]);
        }
        if(max == (int)(1e9)) return -1;
        return max;
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