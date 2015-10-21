class IntRef {
    int val;
    IntRef(int n) { val = n; }
}

public class c17p1 {
    static void swapInPlace(IntRef a, IntRef b){
        int diff = a.val-b.val;
        for (int i=0; i < Math.abs(diff); ++i){
            if (diff > 0){
                a.val--; b.val++;
            } else {
                a.val++; b.val--;
            }
        }
    }

    public static void main(String[] args){
        IntRef a = new IntRef(Integer.parseInt(args[0]));
        IntRef b = new IntRef(Integer.parseInt(args[1]));
        swapInPlace(a, b);
        System.out.println("a: " + a.val);
        System.out.println("b: " + b.val);
    }
}
