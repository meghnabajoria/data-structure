class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // make adj matrix
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<times.length;i++) {
            adj.get(times[i][0]).add(new Node(times[i][1], times[i][2]));
        }
        
         // for(int i=0;i<=n;i++) {
         //     System.out.println("i = " + i);
         //     List<Node> nodes = adj.get(i);
         //     for(int j=0;j<nodes.size();j++) {
         //         Node node = nodes.get(j);
         //         System.out.println("node : " + node.adjNode);
         //         System.out.println("node wt : " + node.wt);
         //     }
         // }
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, (int)1e9);
        distance[k] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>((x,y) -> x.wt - y.wt);
        queue.add(new Node(k,0));
        
        while(!queue.isEmpty()) {
            Node zz = queue.poll();
            int adjNode = zz.adjNode;
            int wt = zz.wt;
            
            for(int i=0;i<adj.get(adjNode).size();i++) {
                Node itrNode = adj.get(adjNode).get(i);
                int tempNode = itrNode.adjNode;
                int tempWt = itrNode.wt;
                
                 if(distance[adjNode] + tempWt < distance[tempNode]) {
                    distance[tempNode] = distance[adjNode] + tempWt;
                    queue.add(new Node(tempNode, distance[adjNode] + tempWt));
                }
            }
        }
        
        int sum = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            if(distance[i] >= (int)1e9)
                return -1;
            else if(distance[i] > sum)
                sum =  distance[i];
        }
        return sum;
    }
}

class Node {
    int adjNode;
    int wt;
    
    public Node(int adjNode, int wt) {
        this.adjNode = adjNode;
        this.wt = wt;
    }
}