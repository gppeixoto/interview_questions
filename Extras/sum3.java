import java.util.*;

public class sum3 {
    public static void main (String[] args) {
        int[] arr = {7, 2, 5, 3};
        ArrayList<Integer> n = new ArrayList<Integer>();
        n.add(7); n.add(2); n.add(5); n.add(3);
        Arrays.sort(arr);
        for (int i=0; i < n.size(); ++i) System.out.println(arr[i]);
    }
}
