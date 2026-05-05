import java.util.*;

public class RootingOranges {
    public static void main(String[] args) {
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        int[][] vis = new int[grid.length][grid[0].length];
        int res = rooten(grid,vis);
        System.out.println(res);
    }

    public static int rooten(int[][] grid,int[][] vis)
    {
        int m = grid.length;
        int n = grid[0].length;
        int fresh=0;

        Queue<Object[]>  q = new LinkedList<>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) q.offer(new Object[]{i,j});
            }
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int count =0;
        while (!q.isEmpty() && fresh>0) 
        {
            int size = q.size();
            count++;
            for(int i =0;i<size;i++)
            {
                Object[] node = q.poll();
                int row = (int) node[0];
                int col = (int) node[1];

                for(int d=0;d<4;d++)
                {
                    int nx = row + dx[d];
                    int ny = col + dy[d];

                    if(nx<0 || ny<0 || nx>=m || ny>=n || grid[nx][ny]!=1)
                        continue;

                    grid[nx][ny] = 2;
                    fresh--;
                    q.offer(new Object[]{nx,ny});
                }

            }
            
        }
    return fresh==0?count:-1;
    }
}
