class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {

    boolean isPossible = true;
    Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
    int[] indegree = new int[numCourses];
    int[] topologicalOrder = new int[numCourses];

    // Create the adjacency list representation of the graph
    for (int i = 0; i < prerequisites.length; i++) {
      int dest = prerequisites[i][0];
      int src = prerequisites[i][1];
      List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
      lst.add(dest);
      adjList.put(src, lst);

      // Record in-degree of each vertex
      indegree[dest] += 1;
    }

    // Add all vertices with 0 in-degree to the queue
    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        q.add(i);
      }
    }

    int i = 0;
    // Process until the Q becomes empty
    while (!q.isEmpty()) {
      int node = q.remove();
      topologicalOrder[i++] = node;

      // Reduce the in-degree of each neighbor by 1
      if (adjList.containsKey(node)) {
        for (Integer neighbor : adjList.get(node)) {
          indegree[neighbor]--;

          // If in-degree of a neighbor becomes 0, add it to the Q
          if (indegree[neighbor] == 0) {
            q.add(neighbor);
          }
        }
      }
    }

    // Check to see if topological sort is possible or not.
    if (i == numCourses) {
      return topologicalOrder;
    }

    return new int[0];
  }
}
// class Solution {
//     public int[] findOrder(int numCourses, int[][] req) {
//         // form a graph
//         if(numCourses <= 0) return new int[0];
        
        
//         List<List<Integer>> adj = new ArrayList<>();
//         int[] indegree = new int[numCourses];
//         Queue<Integer> queue = new LinkedList<>();
//         int[] ans = new int[numCourses];
//         int idx = 0;
        
//         for(int i=0;i<numCourses;i++)
//             adj.add(new ArrayList<>());
        
//         for(int i=0;i<req.length;i++) {
//                 adj.get(req[i][1]).add(req[i][0]);
//         }
        
//         for(int i=0;i<numCourses;i++) {
//             for(int j : adj.get(i)) {
//                 indegree[j]++;
//             }
//         }
        
        
//         for(int i=0;i<numCourses;i++) {
//             if(indegree[i] == 0)
//                 queue.add(i);
//         }
        
//         while(!queue.isEmpty()) {
//             int node = queue.peek();
//             queue.remove();
//             ans[idx++] = node;
            
//              for(int it : adj.get(node)) {
//                 indegree[it]--;
//                 if(indegree[it] == 0)
//                     queue.add(it);
//             }
//         }
        
//         if(ans.length == numCourses) return ans;
//         return new int[0];
//     }
// }

// class Solution {
//     public int[] findOrder(int numCourses, int[][] req) {
//         List<List<Integer>> adj = new ArrayList<>();
//         int[] ans = new int[numCourses];
//         int index = 0;
        
//         for(int i=0;i<numCourses;i++) {
//             adj.add(new ArrayList<>());
//         }
        
//         for(int i=0;i<req.length;i++) {
//             adj.get(req[i][1]).add(req[i][0]);
//         }
        
//         int[] indegree = new int[numCourses];
//         for(int i=0;i<numCourses;i++) {
//             for(int j : adj.get(i)) {
//                 indegree[j]++;
//             }
//         }
        
//         Queue<Integer> queue = new LinkedList<>();
//         for(int i =0; i<numCourses;i++)
//             if(indegree[i] == 0)
//                 queue.add(i);
        
//         List<Integer> topo = new ArrayList<>();
//         while(!queue.isEmpty()) {
//             int node = queue.peek();
//             queue.remove();
            
//             //topo.add(node);
//             ans[index++] = node;
            
//             for(int it : adj.get(node)) {
//                 indegree[it]--;
//                 if(indegree[it] == 0) {
//                     queue.add(it);
//                     //ans[++index] = node;
//                 }
//             }
//         }
        
//         if(ans.length == numCourses)
//             return ans;
//         return new int[0];
//     }
// }