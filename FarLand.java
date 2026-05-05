import java.util.LinkedList;
import java.util.Queue;

public class FarLand {
    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};

        int count = sub(grid);
        System.out.println(count);
    }

    public static int sub(int[][] grid)
    {
        int m =grid.length, n = grid[0].length;
        int[][] arr = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)  {
                    arr[i][j]=0;
                    q.offer(new int[]{i,j});
                }  
                else arr[i][j]=-1;
            }
        }


        while(!q.isEmpty())
        {
            int[] node = q.poll();
            int row = (int)node[0];
            int col = (int) node[1];

            int[] x = {-1,1,0,0};
            int[] y = {0,0,-1,1};

            for(int d=0;d<4;d++)
            {
                int nx = row + x[d];
                int ny = col + y[d];


                if(nx>=0 && ny>=0 && nx<m && ny<n && arr[nx][ny]==-1)
                {
                    arr[nx][ny]=arr[row][col]+1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        int max = 0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]>max)
                    max = arr[i][j];
            }
        }

        return max;
    }
}
