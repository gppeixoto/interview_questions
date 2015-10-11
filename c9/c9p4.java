import java.util.ArrayList;
public class c9p4 {
    public static ArrayList<ArrayList<Integer>> 
        subsets(ArrayList<Integer> set, int index)
    {
        ArrayList<ArrayList<Integer>> all =
        new ArrayList<ArrayList<Integer>>();
        if (set.size() == index) {
            ArrayList<Integer> empty = new ArrayList<Integer>();
            all.add(empty);
            return all;
        }
        all = subsets(set, index+1);
        ArrayList<ArrayList<Integer>> more =
            new ArrayList<ArrayList<Integer>>();
        int item = set.get(index);
        for (ArrayList<Integer> set_ : all){
            ArrayList<Integer> new_set = new ArrayList<Integer>();
            new_set.addAll(set_);
            new_set.add(item);
            more.add(new_set);
        }
        all.addAll(more);
        return all;
    }

    public static ArrayList<ArrayList<Integer>> 
        subsets(ArrayList<Integer> set)
    {
        return subsets(set, 0);
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(1); set.add(2); set.add(3); set.add(4);
        ArrayList<ArrayList<Integer>> all = subsets(set);
        int count = 0;
        for (ArrayList<Integer> sub : all)
        {
            for (Integer i : sub)
            {
                System.out.print(i + " ");
            }
            if (sub.size() == 0) System.out.print("{}");
            count += 1;
            System.out.println();
        }
        System.out.println("total: " + count);  
    }
}