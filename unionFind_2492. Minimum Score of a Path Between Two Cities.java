// 2492. Minimum Score of a Path Between Two Cities
// https://leetcode.com/contest/weekly-contest-322/problems/minimum-score-of-a-path-between-two-cities/

class Solution {
    public int minScore(int n, int[][] roads) {
       UnionFind uf = new UnionFind(n+1);
        for(int i=0;i<roads.length;i++) {
            uf.setUnion(roads[i][0], roads[i][1], roads[i][2]);
            uf.setUnion(roads[i][1], roads[i][0], roads[i][2]);
        }
        return uf.minRoad(1,n);
    }
}

class UnionFind {
    int[] parent = new int[100010];
    int[] roads = new int[100010];
    
    public UnionFind(int n) {
        for(int i=0;i<=n;i++) {
            parent[i] = i;
            roads[i] = Integer.MAX_VALUE;
        }
    }
    
    public int findRoot(int u) {
        if(parent[u] == u)
            return u;
        return findRoot(parent[u]);
    }
    
    public boolean find(int u, int v) {
        return (findRoot(u) == findRoot(v));
    }
    
    public void setUnion(int i, int j, int w) {
        int x = findRoot(i);
        int y = findRoot(j);
        parent[y] = x;
        roads[x] =  Math.min(roads[x], Math.min(roads[y], w));
        
    }
    
    public int minRoad(int u, int v) {
        return Math.min(roads[findRoot(u)], roads[findRoot(v)]);
    }
    
    
}
