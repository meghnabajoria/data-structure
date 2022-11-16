// link : https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/


class Solution {
    public int countPaths(int n, int[][] roads) {
        
        // create adj list
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<roads.length;i++) {
           adj.get(roads[i][0]).add(new Node(roads[i][1], roads[i][2]));
           adj.get(roads[i][1]).add(new Node(roads[i][0], roads[i][2]));
        }
        
        // distance array
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        
        // ways array
        int[] ways = new int[n];
        Arrays.fill(ways, 0);
        ways[0] = 1;
        
        PriorityQueue<Node> queue = new PriorityQueue<Node>((x,y) -> x.second - y.second);
        queue.add(new Node(0, 0));
        
        // bfs
        while(!queue.isEmpty()) {
            
            Node it = queue.peek();
            queue.remove();
            
            int node = it.first;
            int distance = it.second;
            
            for(int i=0;i<adj.get(node).size();i++) {
                
                Node itr = adj.get(node).get(i);
                int destinationNode = itr.first;
                int destinationDes = itr.second;
                
                // find new distance
                int newDistance = distance + destinationDes;
                // first time with hsort dis
                if(dis[destinationNode] > newDistance) {
                    dis[destinationNode] = newDistance;
                    queue.add(new Node(destinationNode, newDistance));
                    ways[destinationNode] = ways[node];
                }
                else if(dis[destinationNode] == newDistance) {
                    ways[destinationNode] = (ways[destinationNode] + ways[node]) % (int)(1e9 + 7);
                }
                
            }
        }
        return ways[n-1];
        
    }
}

class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
