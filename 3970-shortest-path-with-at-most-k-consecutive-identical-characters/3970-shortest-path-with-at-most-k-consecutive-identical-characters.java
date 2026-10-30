import java.util.*;

class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] minWeight = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minWeight[i], Integer.MAX_VALUE);
        }
        
        pq.offer(new int[]{0, 0, 1});
        minWeight[0][1] = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], u = curr[1], count = curr[2];
            
            if (u == n - 1) {
                return d;
            }
            
            if (d > minWeight[u][count]) {
                continue;
            }
            
            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                
                int nextCount = (labels.charAt(u) == labels.charAt(v)) ? count + 1 : 1;
                
                if (nextCount <= k) {
                    if (d + weight < minWeight[v][nextCount]) {
                        minWeight[v][nextCount] = d + weight;
                        pq.offer(new int[]{d + weight, v, nextCount});
                    }
                }
            }
        }
        
        return -1;
    }
}