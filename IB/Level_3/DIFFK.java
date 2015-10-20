public class DIFFK {
    public int diffPossible(ArrayList<Integer> a, int b) {
        int cur = -1;
        int i;
        for (i=0; i < a.size() && cur < b; ++i){
            cur = a.get(i);
        }
        i -= 1;
        int j = 0;
        while (i < a.size() && j < a.size()){
            cur = a.get(i);
            if ((cur - a.get(j) == b) && (i != j))
                return 1;
            else if (cur - a.get(j) < b)
                i += 1;
            else
                j += 1;
        }
        return 0;
    }
}