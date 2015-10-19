public class c5p1 {
    
    public static int copy_bits(int n, int m, int i, int j){
        int left = ~0 << (j+1);
	int right = (1 << j)-1;
	int mask = left | right;
	return (n & mask) | (m << i);
    }

    public static void main(String[] args) {
        int n = 0, m = 3;
        n = copy_bits(n, m, 6, 8);
	System.out.println(n);
    }
}
