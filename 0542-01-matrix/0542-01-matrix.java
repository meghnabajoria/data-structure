class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int [][] dist = new int[n][m];
        
        for(int i=0;i<n;i++) {
            Arrays.fill(vis[i], 0);
            Arrays.fill(dist[i], -1);
        }
        Queue<Pair> queue = new LinkedList<>();
        
        // find all 0
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(mat[i][j] == 0) {
                    queue.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                    dist[i][j] = 0;
                }
            }
        }
        
        int[] dx =  {-1,1,0,0};
        int[] dy =  {0,0,-1,1};
        
        while(!queue.isEmpty()) {
            int x = queue.peek().first;
            int y = queue.peek().second;
            int z = queue.peek().dis;
            dist[x][y] = z;
            queue.remove();
            
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if(vis[nx][ny] == 0) {
                        vis[nx][ny] = 1;
                        queue.add(new Pair(nx,ny,z+1));
                    }
                }
                
            }
        }
        return dist;
    }
}


class Pair {
    int first;
    int second;
    int dis;
    Pair(int first, int second, int dis) {
        this.first = first;
        this.second = second;
        this.dis = dis;
    }
}