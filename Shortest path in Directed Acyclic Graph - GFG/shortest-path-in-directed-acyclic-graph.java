//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		
		// create adj list
		List<List<Node>> adj = new ArrayList<>();
		for(int i=0;i<N;i++) {
		    adj.add(new ArrayList<>());
		}
		for(int i=0;i<edges.length;i++) {
		    for(int j=0;j<edges[i].length;j++) {
		        adj.get(edges[i][0]).add(new Node(edges[i][1], edges[i][2]));
		    }
		}
		
		int[] dis = new int[N];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[0] = 0;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0,0));
		
		// apply bfs
		while(!queue.isEmpty()) {
		    Node node = queue.peek();
		    queue.remove();
		    int currNode = node.node;
		    int currDis = node.dis;
		    for(Node n : adj.get(currNode)) {
		        int newDis = currDis + n.dis;
		        int targetNode = n.node;
		        if(newDis < dis[targetNode]) {
		            dis[targetNode] = newDis;
		            queue.add(new Node(targetNode, newDis));
		        }
		    }
		}
		
		for(int i=0;i<N;i++) {
		    if(dis[i] == Integer.MAX_VALUE) {
		        dis[i] = -1;
		    }
		}
		return dis;
	}
}

class Node {
    int node;
    int dis;
    
    Node(int node, int dis) {
        this.node = node;
        this.dis = dis;
    }
}