import java.util.*;

public class NoOfWaysToGoForDest {
    public static void main(String[] args) {
        int n=7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5}};

        List<List<Integer[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : roads) {
            adj.get(time[0]).add(new Integer[]{time[1], time[2]});
            adj.get(time[1]).add(new Integer[]{time[0], time[2]});
        }

        sub(n,roads,adj);
    }

    public static void sub(int n,int[][] roads,List<List<Integer[]>> adj)
    {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        q.offer(new int[]{0,0,0});
        int[] dist = new int[n];

        Arrays.fill(dist,Integer.MAX_VALUE);

        int len=0;
        while(!q.isEmpty())
        {
            int[] obj = q.poll();
            int node = obj[0];
            int time = obj[1];

            for(Integer[] it: adj.get(node))
            {
                int adjnode = it[0];
                int wt = it[1];
                if(time+wt < dist[adjnode])
                {  
                    
                    dist[adjnode] = time+wt;
                    q.offer(new int[]{adjnode,dist[adjnode]});
                }
                if(time+wt==dist[adjnode])
                    len++;
            }
        }
        System.out.println(len);
    }
   
}
