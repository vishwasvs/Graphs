import java.util.Arrays;
import java.util.*;

public class PathWithMinEffort {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};

        System.out.println(sub(heights));
    }

    public static int sub(int[][] heights)
    {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); //figureout
        int[][] dist = new int[m+1][n+1];

        for(int[] row : dist)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int[][] vis = new int[m][n];
        for(int[] row : vis)
        {
            Arrays.fill(row,-1);
        }
        
        dist[0][0] = 0;
        q.offer(new int[]{0,0,0});
        vis[0][0]=1;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while(!q.isEmpty())
        {
            int[] obj = q.poll();
            int row = obj[0];
            int col = obj[1];
            int path = obj[2];

            if(row==n-1 && col==n-1)
            {
                return(path);
            }

            for(int d=0;d<4;d++)
            {
                int nrow = dx[d]+row;
                int ncol = dy[d]+col;

                if(nrow>=0 && ncol>=0 && nrow<m && ncol <n)
                {
                    int newEffort = Math.max(Math.abs(heights[nrow][ncol]-heights[row][col]),path);
                    
                    if(newEffort < dist[nrow][ncol])
                    {
                        dist[nrow][ncol] = newEffort;
                        q.offer(new int[]{nrow,ncol,newEffort});
                    }
                }
            }

        }

       return 0;
    }
}
