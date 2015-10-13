enum Color{
    Green, Black, White;
}

public class c9p7 {

    public static void fill(
        Color[][] matrix, int i, int j, Color old, Color new_){
        boolean out = (i < 0) || (j >= matrix[0].length) || 
                        (i >= matrix.length) || (j < 0);
        if (!out && matrix[i][j] == old){
            matrix[i][j] = new_;
            fill(matrix, i-1, j, old, new_);
            fill(matrix, i, j-1, old, new_);
            fill(matrix, i+1, j, old, new_);
            fill(matrix, i, j+1, old, new_);
        }
    }

    public static void main(String[] args){
        Color[][] matrix = new Color[4][6];
        for (int i=0; i < 4; ++i) for (int j=0; j < 6; ++j)
            matrix[i][j] = Color.White;
        matrix[2][3] = matrix[1][1] = Color.Green;
        fill(matrix, 0, 0, Color.White, Color.Black);
        for (int i=0; i < matrix.length; ++i) {
            for (int j=0; j < matrix[0].length; ++j)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }   
    }
}