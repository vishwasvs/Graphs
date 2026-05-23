import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        sub(times,adj,n,2);
    }

    public static int  sub(int[][] times,List<List<int[]>> adj,int n, int src)
    {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]); //figureout
        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;


        q.offer(new int[]{src,0});

        while(!q.isEmpty())
        {
            int[] obj = q.poll();
            int node = obj[0];
            int t = obj[1];

            for(int[] it : adj.get(node))
            {
                int adjnode = it[0];
                int wt =  it[1];
                
                if(t+wt < dist[adjnode])
                {
                    dist[adjnode] = t+wt;
                    q.offer(new int[]{adjnode,t+wt});
                }

            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++)
        {
            max = Math.max(max,dist[i]);
        }
        return max;
    }
}
