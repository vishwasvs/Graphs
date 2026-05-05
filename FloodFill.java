import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int[][] grid = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        int sr = 1,sc =1;
        int newColor = 2;

        sub(grid,sr,sc,newColor);

        for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            System.out.print(grid[i][j] + " ");
        }
        System.out.println();
}
    }

    public static int[][] sub(int[][]grid,int sr,int sc,int newColor)
    {
        int val = grid[sr][sc];
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{sr,sc});

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i=0;i<size;i++)
            {   
                Integer[] node = q.poll();
                int row = (int) node[0];
                int col = (int) node[1];

                int[] x = {-1,1,0,0};
                int[] y = {0,0,-1,1};

                for(int d=0;d<4;d++)
                {
                    int nx = row + x[d];
                    int ny = col + y[d];

                    if(nx<0 || ny<0|| nx>=m || ny>=n || grid[nx][ny]!= val)
                        continue;

                    grid[nx][ny] = newColor;
                    q.offer(new Integer[]{nx,ny});
                }
            }

        }
        grid[sr][sc] = newColor;

        return grid;
    }
}
