import java.util.*;

public class CheapestFlights {
    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0,des =3,n=4;

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        sub(flights,src,1,des,adj);
    }

    public static void sub(int[][] flights,int src,int k,int des,List<List<int[]>> adj)
    {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] dist = new int[4];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        q.offer(new int[]{0,0,0});

        while(!q.isEmpty())
        {
            int[] obj = q.poll();
            int node = obj[0];
            int cost = obj[1];
            int i= obj[2];

            for(int[] it : adj.get(node))
            {
                int adjnode = it[0];
                int wcost = it[1];
                if(cost+wcost <dist[adjnode])
                {
                    if(i<=k)
                    {
                        dist[adjnode] = cost + wcost;
                        q.offer(new int[]{adjnode,dist[adjnode],i+1});
                    }
                    
                }
            }
        }

        for(int i=0;i<4;i++)
        {
            System.out.print(dist[i]+" ");
        }
    }
}