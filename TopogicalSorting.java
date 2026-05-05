import java.util.ArrayList;
import java.util.Stack;

public class TopogicalSorting {
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

        int[] res = toposort(adj,V);
        
        for(int i=0;i<V;i++)
        {
            System.out.print(res[i]+" ");
        }
    }   

    public static int[] toposort(ArrayList<ArrayList<Integer>> adj, int V)
    {
        int vis[] = new int[V];
        int[] arr = new int[V];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,vis,V,adj,st);
            }
        }

        for(int i=0;i<V;i++)
        {
            arr[i]=st.peek();
            st.pop();
        }
        return arr;
    }

    public static void dfs(int node,int[] vis,int V, ArrayList<ArrayList<Integer>> adj,Stack<Integer> st)
    {
        vis[node]=1;
       for(int it:adj.get(node))
       {
            if(vis[it]!=1)
            {
                dfs(it, vis, V,adj,st);
            }
       }
       st.push(node);
    }
}
