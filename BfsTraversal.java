import java.util.*;
public class BfsTraversal{
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();


        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);

        adj.get(2).add(0);
        adj.get(2).add(5);

        adj.get(3).add(1);
        adj.get(4).add(1);
        adj.get(5).add(2);

        ArrayList<Integer> res =  bfstr(adj,0);
        System.out.println(res);
    }

    public static ArrayList<Integer> bfstr(ArrayList<ArrayList<Integer>> adj,int start)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] vis = new int[6];
        ArrayList<Integer> res = new ArrayList<>();
        q.offer(start);
        vis[start] = 1;

        while(!q.isEmpty())
        {
            Integer node = q.poll();
            res.add(node);

            for(Integer it : adj.get(node))
            {
                if(vis[it]!=1)
                {
                    vis[it]=1;
                    q.offer(it);
                }
            }
        }
    return res;
    }

}