import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirectedGraph {
    public static void main(String[] args) {
        int N = 9, M = 10;
        int[][] edges = {
            {0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6},
            {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };

        int[] result = sub(edges, N, M, 0);

        for(int i=0;i<N;i++)
        {
            System.out.print(result[i]);
        }
    }

    public static int[] sub(int[][] edges,int n,int m,int src)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[n];
        Arrays.fill(dist,-1);
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{src,0});
        dist[src] =0;

        while(!q.isEmpty())
        {
            int[] qum = q.poll();
            int node = qum[0];
            int dis = qum[1];
            
            for(int it :adj.get(node))
            {
               if(dist[it]==-1)
               {
                    q.offer(new int[]{it,dis+1}); 
                    dist[it]=dist[node]+1;
               }
            }
        }
        
        return dist;

    }
}