import java.lang.Math;

public class c9p2{
    public static int num_paths(int n){
        int[][] board = new int[n][n];
        board[0][0] = 0;
        for (int i=0; i < n; ++i){
            board[i][0] = 1;
            board[0][i] = 1;
        }
        for (int i=1; i < n; ++i){
            for (int j=1; j < n; ++j){
                board[i][j] = 
                    Math.max(
                        board[i-1][j],
                        board[i][j-1]
                    )+1;
            }
        }
        return board[n-1][n-1];
    }

    public static void main(String[] args){
        System.out.println(num_paths(6));
    }
}
