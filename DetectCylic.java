import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCylic {
    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1);

        Queue<Integer> q= new LinkedList<>();
        int[] indegree = new int[V];

        for(int i=0;i<V;i++)
        {
            for(Integer it : adj.get(i))
            {
                indegree[it]++;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();

        System.out.println(toposort(indegree,V,q,adj,res));
    }

    public static boolean toposort(int[] indegree,int V,Queue<Integer> q,List<List<Integer>> adj,ArrayList<Integer> res)
    {
        for(int i=0;i<V;i++)
        {
            if(indegree[i]==0)
                q.offer(i);
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
    return res.size() < V;
    }
}
