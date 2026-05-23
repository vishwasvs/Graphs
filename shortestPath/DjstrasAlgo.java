import java.util.*;

public class DjstrasAlgo {
    public static void main(String[] args) {
       int V = 3, e = 3, s = 2;

        ArrayList<int[]>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        adj[0].add(new int[]{1,1});
        adj[0].add(new int[]{2,6});
        adj[1].add(new int[]{0,1});
        adj[1].add(new int[]{2,3});
        adj[2].add(new int[]{0,6});
        adj[2].add(new int[]{1,3});

        int[] res = sub(e,s,V,adj);

        for(int i=0;i<V;i++)
        {
            System.out.print(res[i]);
        }
    }

    public static int[] sub(int e,int s,int v,ArrayList<int[]>[] adj)
    {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        q.offer(new int[]{s,0});
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s]=0;

        while(!q.isEmpty())
        {
            int[] obj = q.poll();
            int node = obj[0];
            int dis = obj[1];

            for(int[] it : adj[node])
            {
                int adjnode = it[0];
                int weigth = it[1];

                if(dis+weigth < dist[adjnode])
                {
                    dist[adjnode] = dis+weigth;
                    q.offer(new int[]{adjnode,dis+weigth});
                }
            }
        }
        return dist;
    }
}