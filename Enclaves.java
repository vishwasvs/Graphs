import java.util.LinkedList;
import java.util.Queue;

public class Enclaves {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};

        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i == 0 || j == 0 || i == m-1 || j == n-1) {
                    if(grid[i][j] == 1) {
                        q.offer(new int[]{i, j});
                        vis[i][j] = 1;
                    }
            }
        }

        while(!q.isEmpty())
        {
            int[] node = q.poll();
            int row = (int)node[0];
            int col = (int)node[1];

            int[] x = {-1,1,0,0};
            int[] y = {0,0,-1,1};

            for(int d=0;d<4;d++)
            {
                int nx = row + x[d];
                int ny = col + y[d];

                if(nx>=0 && ny>=0 && nx<m && ny<n && grid[nx][ny]==1 && vis[nx][ny]!=1)
                    {
                        vis[nx][ny]=1;
                        q.offer(new int[]{nx,ny});
                    }      
            }
        }

        System.out.println(count);
    }
}}
