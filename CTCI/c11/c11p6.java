public class c11p6 {
    public static boolean find(int[][] matrix, int row, int col, int n) {
        if (
            row < 0 || col >= matrix[0].length || 
            row >= matrix.length || col < 0
            )
            return false;
        
        int cur = matrix[row][col];
        if (cur == n){
            System.out.println("found at" + row+""+col);
            return true;
        }

        if (cur < n)
            return find(matrix, row+1, col, n);
        return find(matrix, row, col-1, n);
    }

    public static boolean find(int[][] matrix, int n){
        return find(matrix, 0, matrix[0].length-1, n);
    }

    public static void main(String[] args) {
        int[][] mat = new int [6][6];
        for (int i=0; i<6; ++i) {
            for (int j=0; j<6; ++j)
                mat[i][j] = i*6+j;
        }
        System.out.println(find(mat, 13));    
    }
}