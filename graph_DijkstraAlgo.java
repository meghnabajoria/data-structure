import java.util.*;
class DijkstraAlgo {
    public static void main(String[] args) {

        int n = 5;
        ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Node>());
        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 4));
        adj.get(2).add(new Node(1, 4));

        adj.get(0).add(new Node(3, 1));
        adj.get(3).add(new Node(0, 1));

        adj.get(3).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 3));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 1));
        adj.get(4).add(new Node(2, 1));

        shortestPath(0, adj, n);
    }

    private static void shortestPath(int s, ArrayList<ArrayList<Node> > adj, int n) {
        int[] distance = new int[n];
        for(int i=0;i<distance.length;i++)
            distance[i] = Integer.MAX_VALUE;
        distance[s] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(n, new Node());
        queue.add(new Node(s,0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(Node nodee : adj.get(node.node)) {
                if(nodee.weight + distance[node.node] < distance[nodee.node]) {
                    int newWeight = nodee.weight + distance[node.node];
                    distance[nodee.node] = newWeight;
                    queue.add(new Node(nodee.node, newWeight));
                }
            }
        }

        for(int i=0;i<n;i++)
            System.out.println(distance[i] + "");
    }
}

class Node implements Comparator<Node>{
    int node;
    int weight;
    Node(){};
    Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compare(Node n1, Node n2) {
        if(n1.weight< n2.weight)
            return -1;
        else if(n1.weight > n2.weight)
            return 1;
        return 0;
    }
}
