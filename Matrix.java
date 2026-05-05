import java.util.LinkedList;
import java.util.Queue;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] res = sub(matrix);

        for(int i=0;i<res.length;i++)
        {
            for(int j =0;j<res[0].length;j++)
            {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] sub(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        int[][] arr = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int i =0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    arr[i][j]=0;
                    q.offer(new int[]{i,j});
                }    

                else
                {
                    arr[i][j]=-1;
                }
            }
        }

        while (!q.isEmpty()) 
        {
            int[] node = q.poll();
            int row = (int)node[0];
            int col = (int) node[1];


            int[] x = {-1,1,0,0};
            int[] y = {0,0,-1,1};

            for(int d=0;d<4;d++)
            {
                int nx = row +x[d];
                int ny = col + y[d];
               
                if(nx>=0 && ny>=0 && nx<m && ny<n && arr[nx][ny]==-1){
                    arr[nx][ny] = arr[row][col]+1;
                    q.offer(new int[]{nx,ny});
                }

            }
            
        }
        return arr;

    }
}
