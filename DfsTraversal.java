import java.util.*;

public class DfsTraversal {
    public static void main(String[] args) {
         int V = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=V;i++)
        {
             adj.add(new ArrayList<>());
        }

        adj.get(1).add(1);
        adj.get(1).add(2);

        adj.get(2).add(5);
        adj.get(2).add(6);

        adj.get(3).add(1);
        adj.get(3).add(4);
        adj.get(3).add(7);

        adj.get(4).add(3);
        adj.get(4).add(8);

        adj.get(5).add(2);
        adj.get(6).add(2);

        adj.get(7).add(3);
        adj.get(7).add(8);

        adj.get(8).add(4);
        adj.get(8).add(7);

        ArrayList<Integer> li = new ArrayList<>();
        int[] vis = new int[V+1];

         for (int i = 1; i <= V; i++) {
            if (vis[i] == 0) {
                dfs(adj, i, vis, li);
            }
        }

        System.out.println(li);
    }

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj,int node,int[] vis,ArrayList<Integer> list)
    {
        vis[node] = 1;
        list.add(node);

        for(Integer l : adj.get(node))
        {
            if(vis[l]!=1)
            {
                dfs(adj,l,vis,list);
            }
        }

        return list;
    }


}
