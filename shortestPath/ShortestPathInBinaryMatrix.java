import java.util.*;

public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int grid[][] = {{0,1},{1,0}};

         System.out.println(sub(grid));
    }

    public static int sub(int[][] arr)
    {
        int m = arr.length;
        int n = arr[0].length;
        
        int[][] dist = new int[m+1][n+1];
        
        for(int[] row : dist)
        {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        dist[0][0] = 1;

        int[] dx = {-1,1,0,0,-1,-1,1,1};
        int[] dy = {0,0,-1,1,-1,1,-1,1};

        while(!q.isEmpty())
        {
            int[] obj = q.poll();
            int row = obj[0];
            int col = obj[1];
            int len = obj[2];

            if(row==m-1 && col==n-1){
                return len;
            }

            for(int d=0;d<8;d++)
            {
                int nrow = row +dx[d];
                int ncol = col + dy[d];

                if(nrow<0 || ncol<0 || nrow>=m || ncol>=n)
                    continue;
                if(arr[nrow][ncol]== 0)
                {
                    q.offer(new int[]{nrow,ncol,len+1});
                    dist[nrow][ncol]=len+1;
                }
                    
            }
        }
        return -1;
    }
}