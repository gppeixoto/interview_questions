public class CountOnes {
    public static int count(int n) {
        int c = 0;
        for (int i=n; i > 0; i >>= 1) {
            c += ((i & 1) != 0) ? 1 : 0;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(count(4019));
    }
}