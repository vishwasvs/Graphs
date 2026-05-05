import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgo {
    public static void main(String[] args) {
        int V = 6;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);


        ArrayList<Integer> res = new ArrayList<>();
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        {
            for(Integer it : adj.get(i))
            {
                indegree[it]++;
            }
        }
        toposort(indegree,adj,V,q,res);
        System.out.println(res);
    }

    public static ArrayList<Integer>  toposort(int[] indegree,ArrayList<ArrayList<Integer>> adj, int V,Queue<Integer> q,ArrayList<Integer> res)
    {
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }

        while(!q.isEmpty())
        {
            int node = q.poll();
            res.add(node);

            for(Integer it : adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                    q.offer(it);
            }
        }
    return res;
    }
}
