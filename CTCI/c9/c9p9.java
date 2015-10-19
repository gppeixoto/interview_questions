import java.lang.Math;
import java.util.ArrayList;

public class c9p9 {

    public static boolean safe(Integer[] brd, int row, int col)
    {
        //brd[row] = col
        for (int row2=0; row2 < row; ++row2) {
            int col2 = brd[row2];
            if (col == col2)
                return false;
            int row_dist = row - row2;
            int col_dist = Math.abs(col - col2);
            if (row_dist == col_dist)
                return false;
        }
        return true;
    }

    public static void queens(
        ArrayList<Integer[]> res, Integer[] brd, int row, int GRID_SIZE
        )
    {
        if (row == GRID_SIZE) res.add(brd.clone());
        for (int col = 0; col < GRID_SIZE; ++col) {
            if (safe(brd, row, col)){
                brd[row] = col;
                queens(res, brd, row+1, GRID_SIZE);
            }
        }
    }

    public static ArrayList<Integer[]> queens(int GRID_SIZE){
        Integer[] brd = new Integer[GRID_SIZE];
        ArrayList<Integer[]> res = new ArrayList<Integer[]>();
        queens(res, brd, 0, GRID_SIZE);
        return res;
    }

    public static void main(String[] args){
        ArrayList<Integer[]> res = queens(8);
        for (Integer[] b : res){
            for(Integer i : b) System.out.print(i + " ");
                System.out.println();
        }
    }
}