import java.util.Random;

public class c1p7
{   

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    static int[][] mat = new int[3][3];
    static int n = 3, m = 3;

    public static void nullify(int row, int col) {
        for (int i=0; i < m; ++i) mat[row][i] = 0;
        for (int j=0; j < n; ++j) mat[j][col] = 0;
    }
    
    public static void nullify() {
        boolean[] arr = new boolean[m];
        boolean[] arr2 = new boolean[n];

        for (int i=0; i<n; ++i) for (int j=0; j<m; ++j) {if (mat[i][j]==0){
            arr[i] = arr[j] = true;
        }}

        for (int i=0; i<n; ++i){
            for (int j=0; j<m; ++j){
                if (mat[i][j]==0 && (arr[i] == true) && (arr2[j] == true)) {
                    nullify(i, j);
                }
            }
        }
    }

    public static void print(){
        for (int i=0; i<n; ++i){
            System.out.println();
            for (int j=0; j<m; ++j) System.out.print(mat[i][j] + " ");
        }
    }

    public static void main(String[] args)
    {
        for (int i=0; i<n; ++i) for (int j=0; j<m; ++j) {
            mat[i][j] = randInt(0, 9);
        }
        print();
        System.out.println();
        nullify();
        print();
    }
}