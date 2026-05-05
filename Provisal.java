import java.util.ArrayList;

public class Provisal {
    public static void main(String[] args) {
         int V = 2;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=V;i++)
        {
             adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(2).add(2);

        int[]  vis = new int[V+1];
        int count = 0;
        for(int i=0;i<=V;i++)
        {
            if(vis[i]==0)
            {
                count++;
                dfs(adj,i,vis);
            }
        }
        System.out.println(count);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj,int node,int[] vis)
    {
        vis[node] = 1;
        
        for(Integer i : adj.get(node))
        {   
            if(vis[i]!=1)
            {
                dfs(adj,i,vis);
            }
        }
    }
}
